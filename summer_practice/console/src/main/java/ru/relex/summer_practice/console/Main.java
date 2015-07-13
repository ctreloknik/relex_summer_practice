package ru.relex.summer_practice.console;

import ru.relex.summer_practice.dao.Impl.*;
import ru.relex.summer_practice.dao.QuestionDao;
import ru.relex.summer_practice.db.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static PersonDaoImpl personDao = new PersonDaoImpl();
    private static Scanner inputReader = new Scanner(System.in);
    private static LectureDaoImpl lectureDao = new LectureDaoImpl();
    private static QuestionDaoImpl questionDao = new QuestionDaoImpl();
    private static RatingDaoImpl ratingDao = new RatingDaoImpl();
    private static List<Lecture> lectures;
    private static List<Question> questions;
	public static void main( String[] args )
    {
        //lectures = lectureDao.ReadAll();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        Menu();
    }

    public static void Menu(){
        while (true){
            System.out.println("=================");
            System.out.println("MENU");
            System.out.println("1: LOG IN");
            System.out.println("2: SIGN UP");
            System.out.println("0: EXIT");
            System.out.print("Enter command: ");
            Person person;
            switch (inputReader.nextLine()){
                case "0": return;
                case "1":
                    person = Login();
                    if (person == null){
                        System.out.println("Incorrect username or password");
                    }else {
                        UserMenu(person);
                    }
                    break;
                case "2":
                    person = Signup();
                    UserMenu(person);
                    break;
                default: System.out.println("Incorrect command");
            }
        }
    }

    public static Person Login(){
        System.out.println("LOG IN");
        System.out.print("username: ");
        String login = inputReader.nextLine();
        System.out.print("password: ");
        String password = inputReader.nextLine();
        return personDao.Login(login,password);
    }

    public static Person Signup(){
        System.out.println("SIGN UP");
        System.out.print("username: ");
        String login = inputReader.nextLine();
        System.out.print("password: ");
        String password = inputReader.nextLine();
        System.out.print("full name: ");
        String fullname = inputReader.nextLine();
        System.out.print("phone number: ");
        String phoneNumber = inputReader.nextLine();
        System.out.print("email: ");
        String email = inputReader.nextLine();
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setFullname(fullname);
        person.setPassword(phoneNumber);
        person.setEmail(email);
        return personDao.Create(person);
    }

    public static void UserMenu(Person person){
        System.out.println("=================");
        System.out.println("Welcome, " + person.getLogin());
        while (true){
            System.out.println("=================");
            System.out.println(person.getFullname()+ " MENU");
            System.out.println("1: SHOW ALL QUESTIONS");
            System.out.println("2: CREATE QUESTION");
            System.out.println("3: LIKE QUESTION");
            System.out.println("4: DISLIKE QUESTION");
            System.out.println("5: SHOW ALL QUESTIONS ORDER BY DATE");
            System.out.println("6: SHOW ALL QUESTIONS ORDER BY RATING");
            System.out.println("7: SHOW ALL QUESTIONS ORDER BY AUTHOR");
            System.out.println("8: SHOW ALL MY QUESTIONS");
            System.out.println("9: DELETE MY QUESTION");
            System.out.println("0: BACK");
            System.out.print("Enter command: ");
            switch (inputReader.nextLine()){
                case "0": return;
                case "1": questions = questionDao.ReadAll(); break;
                case "2": CreateQuesction(person); break;
                case "3": AddRatingQuestion(person, 1); break;
                case "4": AddRatingQuestion(person,-1); break;
                case "5": questions = questionDao.ReadQuestionOrderByDate(OrderByDesc()); break;
                case "6": questions = questionDao.ReadQuestionOrderByRating(OrderByDesc()); break;
                case "7": questions = questionDao.ReadQuestionOrderByPerson(OrderByDesc()); break;
                case "8": questions = questionDao.ReadQuestionByPerson(person); break;
                case "9": DeleteQuestion(person); break;
                default: System.out.println("Incorrect command");
            }
            ShowAllQuestion();
        }
    }

    private static void DeleteQuestion(Person person) {
        System.out.println("SELECT QUESTION");
        questions = questionDao.ReadQuestionByPerson(person);
        ShowAllQuestion();
        System.out.print("NUMBER: ");
        Long number = Long.parseLong(inputReader.nextLine());
        questionDao.Delete(number);
    }

    private static void CreateQuesction(Person person) {
        System.out.println("SELECT LECTURE");
        for (Lecture lecture: lectures){
            System.out.println(lecture.getId()+"\tTheme: "+lecture.getTopic());
            System.out.println("\tDate: "+lecture.getDatetime());
            System.out.println("\tDescription: "+lecture.getDescription());
        }
        System.out.print("NUMBER: ");
        Long number = Long.parseLong(inputReader.nextLine());
        Lecture lecture = lectureDao.Read(number);
        System.out.println("Вы выбрали лекцию "+lecture.getTopic());
        System.out.println("Введите текст вопроса");
        String text = inputReader.nextLine();
        Question question = new Question();
        question.setQuestioner(person);
        question.setDatetime(new Date());
        question.setText(text);
        questionDao.Create(question);
    }

    public static void ShowAllQuestion(){
        if (questions == null){
            questions = questionDao.ReadAll();
        }
        for (Question question: questions){
            System.out.println(question.getId()+"\tAuthor: "+question.getQuestioner().getLogin() +'\t'+question.getRating());
            System.out.println("\t["+question.getDatetime()+"]"+question.getText());
        }
    }

    public static void AddRatingQuestion(Person person, int rating){
        System.out.println("SELECT QUESTION");
        ShowAllQuestion();
        System.out.print("NUMBER: ");
        Long number = Long.parseLong(inputReader.nextLine());
        Question question = questionDao.Read(number);
        ratingDao.AddRating(person, question, rating);
    }

    public static boolean OrderByDesc(){
        System.out.println("Order by desc?");
        System.out.println("Enter Yes or No: ");
        switch (inputReader.nextLine()){
            case "Yes":
            case "Y":
            case "yes":
            case "y": return true;
            case "No":
            case "N":
            case "no":
            case "n": return false;
            default: return false;
        }
    }
}
