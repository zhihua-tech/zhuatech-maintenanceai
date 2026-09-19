/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.maintenanceai;

import cn.zhuatech.maintenanceai.service.PredictiveMaintenanceService;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class PredictiveMaintenanceServiceTests {
    private final PredictiveMaintenanceService service = new PredictiveMaintenanceService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void escalatesDegradingAsset() {
        var result = service.predict(new PredictiveMaintenanceService.Request("CNC-07", new BigDecimal("8.2"),
            new BigDecimal("91"), 4, 42, 3800, 92));
        assertThat(result.riskLevel()).isEqualTo("CRITICAL");
        assertThat(result.maintenanceWithinHours()).isEqualTo(8);
        assertThat(result.evidence()).hasSizeGreaterThanOrEqualTo(3);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void keepsHealthyAssetOnRoutinePlan() {
        var result = service.predict(new PredictiveMaintenanceService.Request("PUMP-02", new BigDecimal("2.1"),
            new BigDecimal("52"), 0, 88, 700, 85));
        assertThat(result.riskLevel()).isEqualTo("STABLE");
        assertThat(result.recommendation()).contains("点检");
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void selectsLowLoadMaintenanceWindowWithRequiredResources() {
        var result = service.planWindow(new PredictiveMaintenanceService.MaintenanceWindowRequest(
            "CNC-07", 120, true, List.of(
                new PredictiveMaintenanceService.CandidateWindow("WIN-A", LocalDateTime.of(2026, 8, 19, 9, 0), 180, 65, 2),
                new PredictiveMaintenanceService.CandidateWindow("WIN-B", LocalDateTime.of(2026, 8, 19, 13, 0), 150, 20, 1),
                new PredictiveMaintenanceService.CandidateWindow("WIN-C", LocalDateTime.of(2026, 8, 19, 15, 0), 60, 10, 2)
            )));
        assertThat(result.planningStatus()).isEqualTo("READY");
        assertThat(result.recommendedWindowId()).isEqualTo("WIN-B");
        assertThat(result.expectedFinishTime()).isEqualTo(LocalDateTime.of(2026, 8, 19, 15, 0));
    }
}
