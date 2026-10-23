/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.maintenanceai.workbench;

import static cn.zhuatech.maintenanceai.workbench.WorkbenchInput.*;

import java.math.*;
import java.util.*;
import org.springframework.stereotype.Service;

/** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
@Service
public class AiWorkbenchService {
  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  public Map<String, Object> execute(Map<String, Object> r) {
    validate(r);
    keys(r, "windowHours", "failures");
    double hours = decimal(r, "windowHours", 0.000001, 1e6).doubleValue();
    var failures = new ArrayList<>(rows(r, "failures", 0, 500));
    Set<String> ids = new HashSet<>();
    for (var f : failures) {
      keys(f, "id", "start", "end");
      unique(ids, id(f, "id"));
      double a = decimal(f, "start", 0, hours).doubleValue(),
          b = decimal(f, "end", 0, hours).doubleValue();
      if (a >= b) throw new IllegalArgumentException("停机结束时间必须晚于开始");
    }
    failures.sort(Comparator.comparingDouble(f -> ((Number) f.get("start")).doubleValue()));
    double downtime = 0, lastEnd = -1;
    for (var f : failures) {
      double a = ((Number) f.get("start")).doubleValue(), b = ((Number) f.get("end")).doubleValue();
      if (a < lastEnd) throw new IllegalArgumentException("停机区间不能重叠");
      downtime += b - a;
      lastEnd = b;
    }
    double operating = Math.max(0, hours - downtime);
    int count = failures.size();
    return Map.of(
        "failureCount",
        count,
        "downtimeHours",
        round(downtime),
        "operatingHours",
        round(operating),
        "availabilityPercent",
        round(operating / hours * 100),
        "mtbfDefined",
        count > 0,
        "mtbfHours",
        count == 0 ? BigDecimal.ZERO : round(operating / count),
        "mttrDefined",
        count > 0,
        "mttrHours",
        count == 0 ? BigDecimal.ZERO : round(downtime / count));
  }
}
