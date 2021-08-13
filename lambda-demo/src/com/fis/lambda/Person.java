package com.fis.lambda;

import java.util.List;
import java.util.ArrayList;
import java.time.chrono.IsoChronology;
import java.time.LocalDate;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate today;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		 this.name =name;
		 this.birthday =birthday;
		 this.gender = gender;
		 this.emailAddress = emailAddress;
	}

	public int getAge() {
		return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}

	public void printPerson() {
		System.out.println(name + ", " + this.getAge());
	}

	public Sex getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static List<Person> createRoster() {

		List<Person> roster = new ArrayList<>();
		roster.add(new Person("RandomName", LocalDate.of(1999, 4, 30), Person.Sex.MALE, "RandomName1@Random.com"));
		roster.add(new Person("RandomName2", LocalDate.of(1996, 3, 22), Person.Sex.FEMALE, "RandomName2@Random.com"));
		roster.add(new Person("RandomeName3", LocalDate.of(2019, 2, 3), Person.Sex.MALE, "RandomName3@Random.com"));
		

		return roster;
	}

}
