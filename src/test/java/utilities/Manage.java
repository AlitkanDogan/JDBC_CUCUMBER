package utilities;

public class Manage {

    private String querySabah = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) < 12";
    private String queryAksam = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) > 12";

    private String languagesQuery = "Select language From heallife_hospitaltraining.languages Where short_code = 'yi'";

    private String q2Query = "select id from heallife_hospitaltraining.appointment_payment where payment_type = 'Offline'";

    private String q1Query = "Select live_consult from  heallife_hospitaltraining.appointment where patient_id=20";

    public String getQ10Query() {
        return q10Query;
    }

    private String q10Query = "select guardian_name from heallife_hospitaltraining.death_report    order by  death_date desc";



    private String q4Query = "select is_active from heallife_hospitaltraining.bed where created_at = '2021-10-25 03:34:25'";

    public String getQ5Query() {
        return q5Query;
    }

    private String q5Query = "select * from heallife_hospitaltraining.bed where is_active= 'no' and bed_group_id=4";

    public String getQ6Query() {
        return q6Query;
    }

    private String q6Query ="select count(id) from heallife_hospitaltraining.birth_report where weight>=2.5";

    public String getQ8Query() {
        return q8Query;
    }
private String q9Query ="select distinct charge_type_id from heallife_hospitaltraining.charge_categories where name like 'P%'";

    public String getQ9Query() {
        return q9Query;
    }

    private String q8Query="select * from heallife_hospitaltraining.blood_donor where id=7";

    public String getQ7Query() {
        return q7Query;
    }

    private String q7Query ="";
    private String q3Query = "select * from heallife_hospitaltraining.appointment_queue where `created_at` between  '2023-5-1' and '2023-5-31'";

    public String getQuerySabah() {
        return querySabah;
    }

    public String getQueryAksam() {
        return queryAksam;
    }

    public String getLanguagesQuery() {
        return languagesQuery;
    }

    public String getQ1Query() {
        return q1Query;
    }

    public String getQ2Query() {
        return q2Query;
    }

    public String getQ3Query() {
        return q3Query;
    }
    public String getQ4Query() {return q4Query;}

}
