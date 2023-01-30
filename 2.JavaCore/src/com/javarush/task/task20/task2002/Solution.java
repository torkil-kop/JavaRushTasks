package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (this.users.size() > 0) {
                for (User user : this.users
                ) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate().getTime());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }

            }
            printWriter.flush();
            printWriter.close();


        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int count = 0;
            while (reader.ready()) {
                this.users.add(new User());
                this.users.get(count).setFirstName(reader.readLine());
                this.users.get(count).setLastName(reader.readLine());
                this.users.get(count).setBirthDate(new Date(Long.parseLong(reader.readLine())));
                this.users.get(count).setMale(Boolean.parseBoolean(reader.readLine()));
                String c = reader.readLine();
                switch (c){
                    case "UKRAINE":
                        this.users.get(count).setCountry(User.Country.UKRAINE);
                        break;
                    case "RUSSIA":
                        this.users.get(count).setCountry(User.Country.RUSSIA);
                        break;
                    default:
                        this.users.get(count).setCountry(User.Country.OTHER);
                }



                count++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
