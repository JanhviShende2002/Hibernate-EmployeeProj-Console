package kalpesh.app;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;





public class App {
	public static void main(String args[]) throws SQLException {
		int choise;
		int num = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Welcome to My Company");
			System.out.println("1 : Insert Employee data");
			System.out.println("2 : Delete Employee data");
			System.out.println("3 : Update  Employee data");
			System.out.println("4 : Display  Employee data ");
			System.out.println("----------------------------------");
			System.out.print("Enter Number to Perform the operations : ");
			choise = sc.nextInt();

			BookDAO dao = new BookDAO();

			switch (choise) {
			// Insert Book
			case 1:
				int id;
				String book_name;
				double book_price;

				System.out.println("Enter book Id : ");
				id = sc.nextInt();
				System.out.println("Enter book name :");
				book_name = sc.next();
				System.out.println("Enter book Price :");
				book_price = sc.nextDouble();

				Book book = new Book(id, book_name, book_price);

				try {
					int i = dao.addBook(book);
					if (i > 0) {
						System.out.println("Book Inserted Successfully.");
					} else {
						System.out.println("Book not  Inserted .");

					}
				} catch (Exception e) {

					e.printStackTrace();
				}

				break;
			// Delete Book
			case 2:
				int deleteId;
				System.out.println("Enter Id to delete book : ");
				deleteId = sc.nextInt();
				try {
					int i = dao.deleteBookById(deleteId);

					if (i > 0) {
						System.out.println("Book Delete Succesfully.");
					} else {
						System.out.println("Book  not Deleted .");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			// update book
			case 3:
				int BookId;
				String updateBookName;
				double updateBookPrice;

				System.out.println("Enter book id : ");
				BookId = sc.nextInt();

				Book oldBook = null;

				oldBook = dao.getBookSById(BookId);

				System.out.println("Show Alreay Exists Book  for particular id ");
				System.out.println("------------------");
				System.out.println(oldBook.getId());
				System.out.println(oldBook.getBook_name());
				System.out.println(oldBook.getBook_price());
				System.out.println("------------------");

				System.out.println("Enter updated name : ");
				updateBookName = sc.next();

				System.out.println("Enter Upadted Price : ");
				updateBookPrice = sc.nextDouble();

				Book updateBook = new Book(BookId, updateBookName, updateBookPrice);

				try {
					int i = dao.updateBook(updateBook);
					if (i > 0) {
						System.out.println("Book Upadated Succesfully.");
					} else {
						System.out.println("Book Not  Upadated .");
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				break;
			// display All books
			case 4:
				List<Book> list = null;
				try {
					list = dao.displayAllBooks();

				} catch (Exception e) {
					e.printStackTrace();
				}
				Iterator<Book> itr = list.iterator();
				System.out.println("Id   Book   Price");
				while (itr.hasNext()) {
					Book book1 = itr.next();
					System.out.print(book1.getId());
					System.out.print("   " + book1.getBook_name() + "   ");
					System.out.println(book1.getBook_price());
				}
				break;

			default:
				System.out.println("Wrong Input");
				break;
			}

			System.out.println("Press 1 to Continue ...");
			num = sc.nextInt();
		} while (num == 1);

	}

}