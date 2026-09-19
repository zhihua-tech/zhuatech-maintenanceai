/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.maintenanceai;

import cn.zhuatech.maintenanceai.service.MaintenanceWorkOrderGovernanceService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class MaintenanceWorkOrderGovernanceServiceTests {
    private final MaintenanceWorkOrderGovernanceService service = new MaintenanceWorkOrderGovernanceService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnsafeWorkOrder() {
        var result = service.assess(new MaintenanceWorkOrderGovernanceService.Request(
                "WO-01", "CRITICAL", false, 1, false, true, 60, 120, false, false));
        assertThat(result.route()).isEqualTo("SAFETY_OR_RESOURCE_BLOCKED");
        assertThat(result.blockers()).hasSize(3);
        assertThat(result.releaseAllowed()).isFalse();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void expeditesReadyCriticalWorkOrder() {
        var result = service.assess(new MaintenanceWorkOrderGovernanceService.Request(
                "WO-02", "CRITICAL", true, 2, true, true, 180, 120, true, true));
        assertThat(result.route()).isEqualTo("EXPEDITE_RELEASE");
        assertThat(result.releaseAllowed()).isTrue();
    }
}
