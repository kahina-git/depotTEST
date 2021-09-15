                                                                                                                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratique1.a18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Utilisateur
 */
public class Pratique1A18 {

   
    public static void main(String[] args) {
        String myJSON=FileReader.loadFileIntoString("json/student.json");
        int i;
        JSONObject singleStudent=JSONObject.fromObject(myJSON);
        
        int student_id;
        String first_name;
        String last_name;
        String date_birth;
        Boolean active;
        Double GPA;
        JSONArray listCoures;
        String codeStudent;
        student_id = singleStudent.getInt("student_id");
        first_name = singleStudent.getString("first_name");
        last_name = singleStudent.getString("last_name");
        active = singleStudent.getBoolean("active");
        date_birth = singleStudent.getString("date_birth");
        GPA = singleStudent.getDouble("GPA");
        listCoures = singleStudent.getJSONArray("results");

        JSONObject singleCourse;
        codeStudent = formatCode(first_name, last_name, date_birth);
        System.out.println(codeStudent);
         
        /*System.out.println(student_id);
        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(date_birth);
        System.out.println(active);*/
       // System.out.println(student_id+ " - "+first_name+" - "+last_name+" - "+date_birth+" - "+active+" - "+GPA);
     
        String cid;
        String title, titleWorse="",titleBest="";
        double mark;
       double min=listCoures.getJSONObject(0).getDouble("mark");
       
       /**revoir cette instruction après avoir fait le refactoring au cours 4 ou 5 ***/
       double max=listCoures.getJSONObject(0).getDouble("mark");
       double sum=listCoures.getJSONObject(0).getDouble("mark");
        for (i=1;i<listCoures.size();i++)
        {
            singleCourse = listCoures.getJSONObject(i);
            cid = singleCourse.getString("course_id");
            title = singleCourse.getString("course_title");
            mark = singleCourse.getDouble("mark");
            // min=mark;
            //max=mark;
            sum = sum + mark;
            if (min > mark) {
                min = mark;
                titleWorse = singleCourse.getString("course_title");
            }
            if (max < mark) {
                max = mark;
                titleBest = singleCourse.getString("course_title");
            }
            
            System.out.println("\t" +cid+" , "+title+" , "+" , "+mark+".");
        
        
        }
        System.out.println("WorstCourse is :"+titleWorse+" a: "+min+", Best course is: "+titleBest+" - "+max+ ", Sum marks is :"+sum);
        /************************fichier catalog.json*******************/
        /***************************************************************/
        /*String myJSON=FileReader.loadFileIntoString("json/catalog.json");
        int i;
        JSONObject singleBook;
        JSONArray mainJSON=JSONArray.fromObject(myJSON);
        String id;
        String title,author;
        Boolean available;
        double price;
        int year;
        Book theBook;
        for (i=0;i<mainJSON.size();i++)
        {
            singleBook=mainJSON.getJSONObject(i);
            available=singleBook.getBoolean("available");
            year=singleBook.getInt("year");
            
            
                
            id=singleBook.getString("id");
            title=singleBook.getString("title");
            author=singleBook.getString("author");

            price=singleBook.getDouble("price");
           
          
            
           
           // System.out.println(id+" - "+title+" - "+author+" - "+available+" - "+price+" - "+year);
               theBook=new Book(id,title,author,available,price,year);
               System.out.println(theBook);
            

            
        }*/
        
//        System.out.println(mainJSON);
      
    }

    private static String formatCode(String first_name, String last_name, String date_birth) {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("d MMMM yyyy",Locale.ENGLISH);
        Date date = null;
        try {
             date =df.parse(date_birth);
        } catch (ParseException ex) {
            Logger.getLogger(Pratique1A18.class.getName()).log(Level.SEVERE, null, ex);
        }
        calendar.setTime(date);
        
        return last_name.substring(0, 3)
                
                .concat(first_name.substring(0, 1)).toUpperCase()
                .concat("-")+
                calendar.get(Calendar.YEAR);
                //.concat(date_birth.substring(date_birth.length() - 4));
    }
    
}
