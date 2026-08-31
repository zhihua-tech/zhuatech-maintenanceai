/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.maintenanceai;

import cn.zhuatech.maintenanceai.service.MaintenanceWorkOrderGovernanceService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaintenanceWorkOrderGovernanceServiceTests {
    private final MaintenanceWorkOrderGovernanceService service = new MaintenanceWorkOrderGovernanceService();

    @Test void blocksUnsafeWorkOrder() {
        var result = service.assess(new MaintenanceWorkOrderGovernanceService.Request(
                "WO-01", "CRITICAL", false, 1, false, true, 60, 120, false, false));
        assertThat(result.route()).isEqualTo("SAFETY_OR_RESOURCE_BLOCKED");
        assertThat(result.blockers()).hasSize(3);
        assertThat(result.releaseAllowed()).isFalse();
    }

    @Test void expeditesReadyCriticalWorkOrder() {
        var result = service.assess(new MaintenanceWorkOrderGovernanceService.Request(
                "WO-02", "CRITICAL", true, 2, true, true, 180, 120, true, true));
        assertThat(result.route()).isEqualTo("EXPEDITE_RELEASE");
        assertThat(result.releaseAllowed()).isTrue();
    }
}
