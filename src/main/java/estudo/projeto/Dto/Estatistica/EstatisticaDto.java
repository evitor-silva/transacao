package estudo.projeto.Dto.Estatistica;

public record EstatisticaDto(
        long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
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
