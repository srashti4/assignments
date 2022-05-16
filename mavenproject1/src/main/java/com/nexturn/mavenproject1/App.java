package com.nexturn.mavenproject1;
import java.util.Scanner;
import MovieDao.*;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Date;
import javax.transaction.Transaction;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import java.util.*;


public class App 
{
    public static void main( String[] args )
    {
    	 
    	Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 5) {
			System.out.println("Press 1: For Add movie ");
			System.out.println("Press 2: For Update Movie");
			System.out.println("Press 3: For Delete Movie");
			System.out.println("Press 4: For Get Movie Details");
			System.out.println("Press 5: For Exit");
			System.out.println("********************************");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Movie movie = new Movie();
				MovieDao movieDao = new MovieDao();
				movieDao.addMovie(movie);
				break;
			case 2:
				MovieDao movieDao3 = new MovieDao();
				movieDao3.updateMovie();
				break;
			case 3:
				MovieDao movieDao2 = new MovieDao();
				movieDao2.deleteMovie();
				break;
			case 4:
				MovieDao mDao = new MovieDao();
				System.out.println(mDao.getMovieDetails());
				break;
			case 5:
				System.exit(0);
				
				break;
			default:
				System.out.println("Please Enter Valid Input");
			}
		}
		
	}

     
    }


