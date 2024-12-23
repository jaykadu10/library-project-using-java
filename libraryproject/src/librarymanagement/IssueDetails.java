
package librarymanagement;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class IssueDetails {
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private static final int FINE_PER_DAY = 5;

    public IssueDetails(LocalDate issueDate, int loanPeriodDays) {
        this.issueDate = issueDate;
        this.dueDate = issueDate.plusDays(loanPeriodDays);
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public long calculateFine() {
        if (returnDate == null || !returnDate.isAfter(dueDate)) {
            return 0;
        }
        return ChronoUnit.DAYS.between(dueDate, returnDate) * FINE_PER_DAY;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}