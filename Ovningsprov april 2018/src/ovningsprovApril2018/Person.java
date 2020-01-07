package ovningsprovApril2018;

public class Person {
	public String name;
	public int yearOfBirth;
	
	public Person(String name, int year){
		this.name=name;
		yearOfBirth=year;
	}
	public int compareTo(Person p, boolean accordingToYear){
            if(accordingToYear){
		if(yearOfBirth<p.yearOfBirth) return -1;
                if(yearOfBirth>p.yearOfBirth) return 1;
                return 0; //årtalen är lika om vi kommer hit                
            }
            else {
                return name.compareToIgnoreCase(p.name);
            }
	}

        public String toString(){
            return name+"\tfödd "+yearOfBirth;
        }
}
