package stepDefinitions;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import utilities.ConfigReader;
import utilities.JDBCReusableMethods;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static org.junit.Assert.*;

import static utilities.JDBCReusableMethods.getStatement;


public class Stepdefinition {
    String query;
    String query1;
    ResultSet rs;
    ResultSet rs1;
    Statement st;


    int flag;

    Manage manage = new Manage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        JDBCReusableMethods.createConnection();
    }

    @Given("Query hazirlanir.")
    public void query_hazirlanir() {
        query = "Select charge_id From heallife_hospitaltraining.ambulance_call Where patient_id=1 AND driver='Smith';";
    }

    @Given("Query calistirilir ve sonuclari alinir.")
    public void query_calistirilir_ve_sonuclari_alinir() throws SQLException {

        rs = getStatement().executeQuery(query);

    }

    @Given("Query sonuclari dogrulanir.")
    public void query_sonuclari_dogrulanir() throws SQLException {
        int expectedData = 2;

        flag = 0;
        while (rs.next()) {
            flag++;
        }
        assertEquals(expectedData, flag);
    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();
    }

    //--------------------------------------------------------

    @Given("Update Query'si hazirlanir.")
    public void update_query_si_hazirlanir() {
        query1 = "insert into heallife_hospitaltraining.appointment (priority,specialist,doctor,amount,message,appointment_status,source,is_opd,is_ipd,live_consult) values (1,2,2,0,'helloTeam113','approved','OFFline','no','yes','yes');";

    }

    @Given("Sonuclari alinir ve dogrulanir.")
    public void sonuclari_alinir_ve_dogrulanir() throws SQLException {

        int sonuc = JDBCReusableMethods.getStatement().executeUpdate(query1);

        int verify = 0;
        if (sonuc > 0) {
            verify++;
        }
        assertEquals(verify, 1);
    }

    //-------------------------------------------------------------------------------

    @Given("Randevu sayilarini ogrenebilecegimiz sql querysi hazirlanir.")
    public void randevu_sayilarini_ogrenebilecegimiz_sql_querysi_hazirlanir() {


    }

    @Given("Query calistirilir ve sonuclar dogrulanir.")
    public void query_calistirilir_ve_sonuclar_dogrulanir() throws SQLException {

        rs = getStatement().executeQuery(manage.getQuerySabah());
        rs.next();
        System.out.println(rs.getInt(1));
        int sabahRandevulari = rs.getInt(1);

        ResultSet rs1 = JDBCReusableMethods.getStatement().executeQuery(manage.getQueryAksam());
        rs1.next();
        System.out.println(rs1.getInt(1));
        int aksamRandevulari = rs1.getInt(1);

        assertTrue(sabahRandevulari < aksamRandevulari);


    }
//-------------------------------------------------------------------------------------

    @Given("Languages tablosuna query gönderilir ve sonuclar dogrulanir.")
    public void languages_tablosuna_query_gönderilir_ve_sonuclar_dogrulanir() throws SQLException {

        rs = getStatement().executeQuery(manage.getLanguagesQuery());
        rs.next();
        String expectedLanguages = "Yiddish";
        String actualLanguages = rs.getString(1);

        assertEquals(expectedLanguages, actualLanguages);
    }

    //Q1____________________________________________________________

    @Given("appoimtment query gonderilir ve  sonuc dogrulanir.")
    public void appoimtment_query_gonderilir_ve_sonuc_dogrulanir() throws SQLException {

        rs = getStatement().executeQuery(manage.getQ1Query());
        rs.next();
        String expectedResult = "yes";
        String actualResult = rs.getString(1);
        assertEquals(expectedResult, actualResult);

    }

    //Q2____________________________________________________________________

    @Then("appointment_payment tablosuna query gonderilir ve sonuclar dogrulanir.")
    public void appointment_paymentTablosunaQueryGonderilirVeSonuclarDogrulanir() throws SQLException {

        rs = getStatement().executeQuery(manage.getQ2Query());

        ArrayList<Integer> actualList = new ArrayList<>();

        while (rs.next()) {
            actualList.add(rs.getInt(1));
        }

        int[] array = {1, 2, 3, 16, 17, 18, 20, 21, 24, 25, 31};
        ArrayList<Integer> expectedList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            expectedList.add(array[i]);
        }
        assertEquals(expectedList, actualList);
    }

    //Q3__________________________________________________________
    @Then("appointment_queue tablosuna Q3 gondrilir ve sonuc getirilir.")
    public void appointment_queue_tablosuna_q3_gondrilir_ve_sonuc_getirilir() throws SQLException {

        rs = getStatement().executeQuery(manage.getQ3Query());

        Map map = new TreeMap();

        Object value = "";

        while (rs.next()) {

            for (int i = 2; i <= 6; i++) {
                value += ", " + rs.getString(i);
            }

            map.put(rs.getInt("id"), value);


            value = "";
        }
        for (Object each : map.entrySet()
        ) {
            System.out.println(each);

        }

    }

    //Q4---------------------------------------------------------------------------
    @Then("bed tablosuna sorgu gonderilir ve sonuc dogrulanir.")
    public void bed_tablosuna_sorgu_gonderilir_ve_sonuc_dogrulanir() throws SQLException {
        rs = getStatement().executeQuery(manage.getQ4Query());
        rs.next();
        String expectedResult = "yes";
        String ectualResult = rs.getString(1);
        assertEquals(expectedResult, ectualResult);

    }

    //Q5----------------------------------------------------------------

    @Then("bed tablosuna query5 gönderilir ve name bilgisinin {int} olduğu doğrulanır.")
    public void bed_tablosuna_query5_gönderilir_ve_name_bilgisinin_olduğu_doğrulanır(Integer int1) throws SQLException {

        rs = getStatement().executeQuery(manage.getQ5Query());
        rs.first();

        String expectedName = "105";
        String actualName = rs.getString("name");
        assertEquals(expectedName, actualName);

    }

    //Q6_----------------------------------------------------------------
    @Given("Databese'e query gonderılır ve sonuc dogrulanır")
    public void databese_e_query_gonderılır_ve_sonuc_dogrulanır() throws SQLException {
        rs = getStatement().executeQuery(manage.getQ6Query());
        rs.next();

        int expectedCount = 6;
        int actualCount = Integer.parseInt(rs.getString(1));
        assertEquals(expectedCount, actualCount);

    }

    //Q7____________________________________________________________________
    @Given("birth_report tablosuna query gönderilir sonuc dogrulanır")
    public void birth_report_tablosuna_query_gönderilir_sonuc_dogrulanır() throws SQLException {

        String sorgu1 = "SELECT father_name FROM heallife_hospitaltraining.birth_report group by father_name having count(*)>1 ";
        rs = getStatement().executeQuery(sorgu1);
        rs.next();
        String baba = (String) rs.getString(1);
        String sorgu2 = "SELECT child_name FROM heallife_hospitaltraining.birth_report where father_name=" + "'" + baba + "'";
        rs = getStatement().executeQuery(sorgu2);


        List<String> expectedChildList = new ArrayList<>();
        expectedChildList.add("Rohit");
        expectedChildList.add("Reyana");
        expectedChildList.add("child");
        List<String> actualChildList = new ArrayList<>();

        while (rs.next()) {
            actualChildList.add(rs.getString(1));
        }

        assertEquals(expectedChildList, actualChildList);
    }

    //Q8_________________________________________________________
    @Given("blood_donor tablosuna query gonderilir, gelen sonuc dogrulanir")
    public void blood_donor_tablosuna_query_gonderilir_gelen_sonuc_dogrulanir() throws SQLException {
        rs = getStatement().executeQuery(manage.getQ8Query());

        rs.next();

        String expected = "Maria";
        String actual = rs.getString(2);
        assertTrue(actual.contains(expected));

        expected = "2001-03-02";
        actual = rs.getString(3);
        assertTrue(actual.contains(expected));

        expected = "Jhonson";
        actual = rs.getString(6);
        assertTrue(actual.contains(expected));

        expected = "England";
        actual = rs.getString(7);
        assertTrue(actual.contains(expected));

    }
    //Q9______________________________________________________

    @Given("Charge_categories tablosuna query gonderılır ve sonuc dogrulanır")
    public void charge_categories_tablosuna_query_gonderılır_ve_sonuc_dogrulanır() throws SQLException {
        rs = getStatement().executeQuery(manage.getQ9Query());

        List<String> expectedList = new ArrayList<>();
        expectedList.add("6");
        expectedList.add("7");

        System.out.println("expected : " + expectedList);

        List<String> actualList = new ArrayList<>();
        while (rs.next()) {
            actualList.add(rs.getString(1));
        }


        System.out.println("actual : " + actualList);

        assertEquals(expectedList, actualList);

    }

    //Q10_-------------------------------------------------------------
    @Given("death_report toplosuna query gönderilir gelen responce dogrulanir")
    public void death_report_toplosuna_query_gönderilir_gelen_responce_dogrulanir() throws SQLException {
        rs = getStatement().executeQuery(manage.getQ10Query());

        rs.next();
        String expectedResult = "Kane Stark";
        String actualResuld = rs.getString(1);
        assertEquals(expectedResult, actualResuld);

    }
    //Q11_-------------------------------------------------------------
    @Given("discharge_card tablosuna query gönderilir responce doğrulanır")
    public void discharge_card_tablosuna_query_gönderilir_responce_doğrulanır() throws SQLException {
        rs = getStatement().executeQuery(manage.getQ11Query());

        List<String> expectedList = new ArrayList<>();
        expectedList.add("2021-10-28 04:48:56");
        expectedList.add("2023-05-03 13:34:59");
        expectedList.add("2023-05-03 13:25:15");

        System.out.println("expected : " + expectedList);

        List<String> actualList = new ArrayList<>();
        while (rs.next()) {
            actualList.add(rs.getString(1));
        }


        System.out.println("actual : " + actualList);

        assertEquals(expectedList, actualList);

    }
//Q12_-------------------------------------------------------------
@Given("doctor_shift tablosuna query gönderilir responce doğrulanır")
public void doctor_shift_tablosuna_query_gönderilir_responce_doğrulanır() throws SQLException {

        rs = getStatement().executeQuery(manage.getQ12Query());

        int expectedResult=2;
        rs.next();
        int actualResult=Integer.parseInt(rs.getString(6))-Integer.parseInt(rs.getString(5));
    System.out.println(actualResult);


    }


}



