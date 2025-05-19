package estudo.projeto.estatistica;

import java.util.DoubleSummaryStatistics;

public class EstatisticaDto {
    private final long count;
    private final Double sum;
    private final Double avg;
    private final Double min;
    private final Double max;

    public EstatisticaDto() {
        this(new DoubleSummaryStatistics());
    }

    public EstatisticaDto(DoubleSummaryStatistics doubleSummaryStatistics) {
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.avg = doubleSummaryStatistics.getAverage();
        this.min = doubleSummaryStatistics.getMin() == Double.POSITIVE_INFINITY ? 0 : doubleSummaryStatistics.getMin();
        this.max = doubleSummaryStatistics.getMax() == Double.NEGATIVE_INFINITY ? 0 : doubleSummaryStatistics.getMax();
    }

    public long getCount() {
        return count;
    }

    public Double getSum() {
        return sum;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

}
