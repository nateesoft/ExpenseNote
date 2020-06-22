package sun.natee.app.bean;

public class Schedule {

    private int id;
    private String item_desc;
    private String item_type;
    private String month_date;
    private String year_date;
    private String end_month;
    private String holidy_skip;
    private Integer month_at;
    private String before_deadline;
    private String chkSuccess;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getMonth_date() {
        return month_date;
    }

    public void setMonth_date(String month_date) {
        this.month_date = month_date;
    }

    public String getYear_date() {
        return year_date;
    }

    public void setYear_date(String year_date) {
        this.year_date = year_date;
    }

    public String getEnd_month() {
        return end_month;
    }

    public void setEnd_month(String end_month) {
        this.end_month = end_month;
    }

    public String getHolidy_skip() {
        return holidy_skip;
    }

    public void setHolidy_skip(String holidy_skip) {
        this.holidy_skip = holidy_skip;
    }

    public Integer getMonth_at() {
        return month_at;
    }

    public void setMonth_at(Integer month_at) {
        this.month_at = month_at;
    }

    public String getBefore_deadline() {
        return before_deadline;
    }

    public void setBefore_deadline(String before_deadline) {
        this.before_deadline = before_deadline;
    }

    public String getChkSuccess() {
        return chkSuccess;
    }

    public void setChkSuccess(String chkSuccess) {
        this.chkSuccess = chkSuccess;
    }

}
