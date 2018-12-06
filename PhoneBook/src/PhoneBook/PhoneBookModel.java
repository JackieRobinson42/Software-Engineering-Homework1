package PhoneBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;

/*
 * Model data for the phone book application.  
 */

public class PhoneBookModel {

	private PhoneBookView phonebookview;

	// The following are various states captured by the model
	public static String ADD_NAME_STATE = "ADD_NAME";
	public static String ADD_NUMBER_STATE = "ADD_NUMBER";
	public static String SEARCH_STATE = "SEARCH";

	// Update
	public static String UPDATE_NAME_STATE = "UPDATE_NAME";
	public static String UPDATE_NUMBER_STATE = "UPDATE_NUMBER";
	public static String UPDATE_RESULT_STATE = "UPDATE_RESULT";

	// Delete
	public static String DELETE_STATE = "DELETE_NAME";
	public static String DELETE_RESULT_STATE = "DELETE_RESULT";

	public static String IDLE_STATE = "IDLE";
	public static String SEARCH_RESULT_STATE = "SEARCH_RESULT";
	public static String ERROR_STATE = "ERROR";
	public static String EXIT_STATE = "EXIT";

	// Private fields used to track various model data
	private String state = IDLE_STATE;
	private String searchResult = null;

	// Update and Delete result
	private String updateResult = null;
	private String deleteResult = null;

	private PhoneDB phoneDB;

	/**
	 * set the state
	 * 
	 * @param aState
	 */
	public void setState(String aState) {
		state = aState;
		phonebookview.stateHasChanged(this, state);
	}

	/**
	 * add a phone entry
	 * 
	 * @param name
	 * @param number
	 */
	public void addAnEntry(String name, String number) {
		phoneDB.addAnEntry(name, number);
	}

	/**
	 * search the phone number and set the searchResult field
	 * 
	 * @param name
	 */
	public void searchPhoneNumber(String name) {
		searchResult = phoneDB.searchPhoneNumber(name);
	}

	/**
	 * return the search result
	 */
	public String getSearchResult() {
		return searchResult;
	}

	/**
	 * get the state
	 */
	public String getState() {
		return state;
	}

	// update the data
	public void updateData(String name, String number) {
		updateResult = phoneDB.updateData(name, number);
	}

	public String getUpdateResult() {
		return updateResult;
	}

	// delete the data
	public void deleteData(String name) {
		deleteResult = phoneDB.deleteData(name);
	}

	public String getDeleteResult() {
		return deleteResult;
	}

	/**
	 * constructor
	 * 
	 * @param view
	 */
	public PhoneBookModel(PhoneBookView view) {
		phonebookview = view;
		phoneDB = new AccessDataBase("Data.accdb");
		// phoneDB = new TextDataBase("Data.txt");
	}

}
