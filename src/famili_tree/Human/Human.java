package famili_tree.Human;





import java.io.Serializable;
import java.time.*;
import java.util.*;

import famili_tree.Pol.Pol;

import java.time.format.DateTimeFormatter;
 

public class Human implements Serializable{
    String name;
    String familiya;
    Pol pol;
    public Human suprug;
    LocalDate birthDate, dethDate;
    List <Human> parents;
    public List <Human> children;
    
    
    
    public Human( String name, String familiya, String pol, String birthDate, String dethDate ){
       
        this.name= name;
        this.familiya=familiya;
        if (pol.equals("man")){
            this.pol = Pol.valueOf("man");
        }else if (pol.equals("woman")){
            this.pol = Pol.valueOf("woman");
        }else{
            System.out.println("vvedite pol: man ili woman");
        }
        
        this.children= new ArrayList<>();
        this.parents= new ArrayList<>();
        if (birthDate != null && !birthDate.equals("")){
            
            this.birthDate=getBirtdayDate(birthDate);
        }
        
        if (dethDate != null && !dethDate.equals("")){
            
            this.dethDate=getdethDate(dethDate);
        }
            
        
    }
    
    

    



    public Human( String name, String familiya, String pol, String birthDate  ){
        this (name,  familiya,  pol, birthDate,  null);
    }
    
    public Human( String name, String familiya, String pol ){
        this (name,  familiya,  pol,  null, null);
    }
    
    public  void setBirthDate(int year,int month,int day  ){
        this.birthDate = LocalDate.of(year, month, day);
    }
    
    public  void setDethDate(int year,int month,int day  ){
        this.dethDate = LocalDate.of(year, month, day);
    }
    
    public String toString(){
        if (dethDate==null ){
            return String.format("%s;  %s; %s; data rozhdenia: %s; (%s)",this.name,this.familiya,this.pol , this.birthDate, getVozrast() );
        }else{
            return String.format("%s;  %s; %s; data rozhdenia: %s; data smerty: %s; (%s)",this.name,this.familiya,this.pol , this.birthDate, this.dethDate, getVozrast() );
        }
            
    }
    
   public void addChildren(Human child ){
       if (!children.contains(child)){
           children.add(child);
       }
       else{
           System.out.println("danniy chelovek uzhe dobavlen");
       }
   }
   
   public void setParents(Human parent ){
       parents.add(parent);
   }
   
   public List<Human>  getChildren(){
       return this.children;
   }
   
   public List<Human>  getParents(){
       return this.parents;
   }
   
    public String getVozrast(){
        LocalDate date= LocalDate.now();
       if (dethDate==null ){
           if (birthDate==null){
               return "Ne ustanovlen";
           }else{
                return Integer.toString(Period.between(birthDate, date).getYears());
           }
   
       }else{
           return Integer.toString(Period.between(birthDate, dethDate).getYears());
       }   
    }
    
    public void addSuprug(Human supr ){
       if (this.suprug==null && supr.suprug==null){
            this.suprug=supr;
            supr.suprug=this;
       }
       else{
           System.out.println("Uzhe v brake");
       }
   }

    private LocalDate getBirtdayDate(String birthDate) {
        
        DateTimeFormatter formatter;
        formatter= DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return LocalDate.parse(birthDate, formatter);
    }

    private LocalDate getdethDate(String dethDate) {
        
        DateTimeFormatter formatter;
        formatter= DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return LocalDate.parse(dethDate, formatter);
    }

   


}