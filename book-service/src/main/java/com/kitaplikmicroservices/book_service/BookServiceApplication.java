package com.kitaplikmicroservices.book_service;

import com.kitaplikmicroservices.book_service.model.Book;
import com.kitaplikmicroservices.book_service.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public BookServiceApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Nutuk",2019,"Mustafa Kemal Atatürk "," TÜRKİYE İŞ BANKASI ","9789944888349");
		Book book2 = new Book("Geometri", 2018, "Mustafa Kemal Atatürk", " PANAMA YAYINCILIK", "9786052221112");
		Book book3 = new Book("Harry Potter ve Felsefe Taşı", 1997, "J. K. Rowling", "YKB Yayınları", "9789750853258");
		Book book4 = new Book("Puslu Kıtalar Atlası",2021,"İhsan Oktay Anar "," İLETİŞİM YAYINLARI","9789754704723");
		Book book5 = new Book("Yüzüklerin Efendisi", 1960, "J.R.R Tolkien", "Metis Yayıncılık", "9789753425988");

		List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4,book5));

		bookList.forEach(System.out::println);


	}
}
