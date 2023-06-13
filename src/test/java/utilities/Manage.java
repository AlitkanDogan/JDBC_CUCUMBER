package utilities;

public class Manage {

    private String querySabah = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) < 12";
    private String queryAksam = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) > 12";

    private String languagesQuery = "Select language From heallife_hospitaltraining.languages Where short_code = 'yi'";

    private String q2Query = "select id from heallife_hospitaltraining.appointment_payment where payment_type = 'Offline'";

    private String q1Query = "Select live_consult from  heallife_hospitaltraining.appointment where patient_id=20";



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

    public String getQ3Query() {return q3Query;}

}
