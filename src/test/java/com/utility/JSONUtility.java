package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJSON(Env env)  {
		Gson gson = new Gson();
		/**
		 * 	✅ Locate your JSON file on disk
			✅ Open a stream to read the file
			✅ Use Gson to deserialize JSON → Java objects
			✅ Retrieve specific data from those objects
			✅ Print the desired value
		 */
		File jsonFile = new File(System.getProperty("user.dir")+"\\config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class); //fromJson -> converts JSON text into a Java object.
		Environment environment = config.getEnvironments().get("QA");
		return environment;
		

	}

}
