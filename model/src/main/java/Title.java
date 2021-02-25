import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Title {

    private final int titleId;

    private final long budget;

    private final LocalDate premiereDate;

    private final LocalTime runtime;

    private final long boxOffice;

    public Title(int titleId, long budget, LocalDate premiereDate, LocalTime runtime, long boxOffice) {
        this.titleId = titleId;
        this.budget = budget;
        this.premiereDate = premiereDate;
        this.runtime = runtime;
        this.boxOffice = boxOffice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleId, budget, premiereDate, runtime, boxOffice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Title title = (Title) o;
        return titleId == title.titleId && budget == title.budget && boxOffice == title.boxOffice && Objects.equals(premiereDate, title.premiereDate) && Objects.equals(runtime, title.runtime);
    }

    @Override
    public String
    toString() {
        return "Title{" +
                "titleId=" + titleId +
                ", budget=" + budget +
                ", premiereDate=" + premiereDate +
                ", runtime=" + runtime +
                ", boxOffice=" + boxOffice +
                '}';
    }

    public int getTitleId() {
        return titleId;
    }

    public long getBudget() {
        return budget;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public LocalTime getRuntime() {
        return runtime;
    }

    public long getBoxOffice() {
        return boxOffice;
    }
}
