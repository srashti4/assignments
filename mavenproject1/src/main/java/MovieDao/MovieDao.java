package MovieDao;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nexturn.mavenproject1.Movie;

public class MovieDao {
	Scanner sc = new Scanner(System.in);

	public void addMovie(Movie movie) {
		Configuration cfg = new Configuration().configure(); //Loads hibernate.cfg.xml

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		Metadata metadata = new MetadataSources(reg).addAnnotatedClass(Movie.class).getMetadataBuilder()
				.build();
//		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();

		Session session = factory.openSession();
		String choiceString = "no";
		Scanner scanner = new Scanner(System.in);
		org.hibernate.Transaction tx;
		do {
			tx = session.beginTransaction();
			Movie movie1 = new Movie();
			System.out.println("Enter Movie Id");
			movie.setMovieId(scanner.nextLine());
			System.out.println("Enter Movie Name");
			movie.setMovieName(scanner.nextLine());
			System.out.println("Enter Movie language ");
			movie.setLanguage(scanner.nextLine());
			System.out.println("Enter Released Ln");
			movie.setReleasedln(scanner.nextInt());
			System.out.println("Enter Movie Revenue  Amount");
			movie.setRevenuelnDollars(scanner.nextInt());
			session.save(movie);
//	    	session.flush();
			tx.commit();
			System.out.println("Inserted Record Succesfully");
			System.out.println("Do you want to insert more record y/n");

		} while (choiceString.equals("yes") | choiceString.equals("y"));
//		session.close();
		factory.close();

	}

	public void deleteMovie() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		org.hibernate.SessionFactory factory = cfg.buildSessionFactory();
		org.hibernate.Session session = factory.openSession();
		org.hibernate.Transaction txTransaction=session.beginTransaction();
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Movie Id  to Update");
		Movie movie= (Movie)session.get(Movie.class, scanner.nextLine());
		if(movie!=null)
		{
			session.delete(movie);
			session.flush();
			txTransaction.commit();
			System.out.println("One record Delete Successfully");
		}
		else {
			System.out.println("Record Not Found Please Enter Corrent Movie Id");
			
		}
		session.close();
	    factory.close();
	}

	public void updateMovie() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		org.hibernate.SessionFactory factory = cfg.buildSessionFactory();
		org.hibernate.Session session = factory.openSession();
		org.hibernate.Transaction txTransaction=session.beginTransaction();
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Movie Id  to Update");
		Movie movie= (Movie)session.get(Movie.class, scanner.nextLine());
		
		if(movie!=null)
		{
			movie.setRevenuelnDollars(movie.getRevenuelnDollars()+100000);
			session.update(movie);
			session.flush();
			txTransaction.commit();
			System.out.println("one Record Update Successfully");
		}
		else {
			System.out.println("Record Not Found Please Enter Corrent Movie Id");
			
		}
		session.close();
	    factory.close();
		
	}

	public Movie getMovieDetails() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		org.hibernate.SessionFactory factory = cfg.buildSessionFactory();
		org.hibernate.Session session = factory.openSession();

		System.out.println("Enter the Movie id ");
		Movie movie = (Movie) session.get(Movie.class, sc.nextLine());

		if (movie!=null) 
		{
			System.out.println(movie);	
		 }
		else {
			System.out.println("Record Not Found");
		}
		

		session.close();
		factory.close();

		return movie;

	}

}



