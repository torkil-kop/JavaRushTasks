package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("e:\\111.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            if (ivanov.equals(somePerson)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            outputStream.write((this.name + "\n").getBytes());
            if (this.assets.size() > 0) {
                for (Asset asset : this.assets
                ) {
                    outputStream.write((asset.getName() + "\n").getBytes());
                    outputStream.write((asset.getPrice() + "\n").getBytes());
                }
            }
            outputStream.flush();
            outputStream.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            while (reader.ready()){
                this.assets.add(new Asset(reader.readLine(), Double.parseDouble(reader.readLine()) ));
            }






            /*ArrayList<String> strings = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            String str = "";
            while (inputStream.available() > 0) {
                int b = inputStream.read();

                if (b == 10) {
                    // str = stringBuilder.toString();
                    strings.add(stringBuilder.toString());

                    stringBuilder = new StringBuilder(str);
                } else {
                    stringBuilder.append((char) b);

                }
            }
            inputStream.close();
            //System.out.println(strings.size());
*/

           /* StringBuilder stringBuilder = new StringBuilder();
            String str = "";

            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == 10) {
                   // str = stringBuilder.toString();
                    strings.add(stringBuilder.toString());
                 stringBuilder = new StringBuilder(str);
                }
                else {
                    stringBuilder.append((char) bytes[i]);

                }
            }

            */

          /*  this.name = strings.get(0);
            if (strings.get(1) != null) {
                for (int i = 1; i < strings.size(); i = i + 2) {
                    this.assets.add(new Asset(strings.get(i), Double.parseDouble(strings.get(i + 1))));
                }
            }
        }
        */
        }
    }
}
