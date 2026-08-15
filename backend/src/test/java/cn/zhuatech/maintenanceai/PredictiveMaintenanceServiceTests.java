/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.maintenanceai;

import cn.zhuatech.maintenanceai.service.PredictiveMaintenanceService;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

class PredictiveMaintenanceServiceTests {
    private final PredictiveMaintenanceService service = new PredictiveMaintenanceService();

    @Test void escalatesDegradingAsset() {
        var result = service.predict(new PredictiveMaintenanceService.Request("CNC-07", new BigDecimal("8.2"),
            new BigDecimal("91"), 4, 42, 3800, 92));
        assertThat(result.riskLevel()).isEqualTo("CRITICAL");
        assertThat(result.maintenanceWithinHours()).isEqualTo(8);
        assertThat(result.evidence()).hasSizeGreaterThanOrEqualTo(3);
    }

    @Test void keepsHealthyAssetOnRoutinePlan() {
        var result = service.predict(new PredictiveMaintenanceService.Request("PUMP-02", new BigDecimal("2.1"),
            new BigDecimal("52"), 0, 88, 700, 85));
        assertThat(result.riskLevel()).isEqualTo("STABLE");
        assertThat(result.recommendation()).contains("点检");
    }
}
