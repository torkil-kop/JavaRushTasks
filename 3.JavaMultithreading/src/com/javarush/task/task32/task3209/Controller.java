package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.undo.UndoManager;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void resetDocument() {
        if (this.document != null)
            this.document.removeUndoableEditListener(view.getUndoListener());
        Document document = new HTMLEditorKit().createDefaultDocument();
        this.document = (HTMLDocument) document;
        this.document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        try {


            resetDocument();
            StringReader stringReader = new StringReader(text);
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        currentFile = null;
    }

    /*
    20.1. Реализуй метод создания нового документа createNewDocument() в контроллере. Он должен:
20.1.1. Выбирать html вкладку у представления.
20.1.2. Сбрасывать текущий документ.
20.1.3. Устанавливать новый заголовок окна, например: "HTML редактор". Воспользуйся методом setTitle(), который унаследован в нашем представлении.
20.1.4. Обнулить переменную currentFile (присвоить ей значение null).
20.2. Реализуй метод инициализации init() контроллера.
Он должен просто вызывать метод создания нового документа.
Проверь работу пункта меню Новый.


Requirements:
1. Метод createNewDocument() в контроллере должен выбирать html вкладку у представления.
2. Метод createNewDocument() в контроллере должен сбрасывать текущий документ.
3. Метод createNewDocument() в контроллере должен устанавливать новый заголовок окна.
4. Метод createNewDocument() в контроллере должен обнулить currentFile.
5. Метод init() в контроллере должен вызывать метод создания нового документа.
     */
    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());

        if (jFileChooser.showOpenDialog(view) == JFileChooser.OPEN_DIALOG) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try (FileReader fileReader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(fileReader, document, 0);
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile != null) {
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        } else {
            saveDocumentAs();
        }
    }

    /*
    23.1. Напишем метод для сохранения открытого файла saveDocument().
    Метод должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а использовать currentFile.
    Если currentFile равен null, то вызывать метод saveDocumentAs().
    23.2. Пришло время реализовать метод openDocument().
    Метод должен работать аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.

    Подсказка: Обрати внимание на имя метода для показа диалогового окна.

    Когда файл выбран, необходимо:
    23.2.1. Установить новое значение currentFile.
    23.2.2. Сбросить документ.
    23.2.3. Установить имя файла в заголовок у представления.
    23.2.4. Создать FileReader, используя currentFile.
    23.2.5. Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.
    23.2.6. Сбросить правки (вызвать метод resetUndo представления).
    23.2.7. Если возникнут исключения - залогируй их и не пробрасывай наружу.
    Проверь работу пунктов меню Сохранить и Открыть.


    Requirements:
    1. Метод saveDocument() в контроллере должен переключать представление на html вкладку.
    2. Метод saveDocument() в контроллере должен создавать FileWriter на базе currentFile, если currentFile != null.
    3. Метод saveDocument() в контроллере должен используя HTMLEditorKit переписывать данные из документа document в объект FileWriter-а, если currentFile != null.
    4. Метод saveDocument() в контроллере должен вызывать метод saveDocumentAs(), если currentFile == null.
    5. Метод saveDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
    6. Метод openDocument() в контроллере должен переключать представление на html вкладку.
    7. Метод openDocument() в контроллере должен создавать новый объект для выбора файла JFileChooser.
    8. Метод openDocument() в контроллере должен устанавливать объекту класса JFileChooser в качестве фильтра объект HTMLFileFilter.
    9. Метод openDocument() в контроллере должен, используя метод showOpenDialog() у JFileChooser показывать диалоговое окно "Open File" для выбора файла.
    10. Метод openDocument() в контроллере должен установить новое значение currentFile, если пользователь подтвердит выбор файла.
    11. Метод openDocument() в контроллере должен сбросить документ, если пользователь подтвердит выбор файла.
    12. Метод openDocument() в контроллере должен устанавливать имя файла в качестве заголовка окна представления, если пользователь подтвердит выбор файла.
    13. Метод openDocument() в контроллере должен создавать FileReader на базе currentFile, если пользователь подтвердит выбор файла.
    14. Метод openDocument() в контроллере должен используя HTMLEditorKit вычитать данные из FileReader-а в документ document, если пользователь подтвердит выбор файла.
    15. Метод openDocument() в контроллере должен сбросить правки, если пользователь подтвердит выбор файла.
    16. Метод openDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
     */
    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());

        if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }


}
/*
Реализуем в контроллере метод для сохранения файла под новым именем saveDocumentAs().
Реализация должна:
22.1. Переключать представление на html вкладку.
22.2. Создавать новый объект для выбора файла JFileChooser.
22.3. Устанавливать ему в качестве фильтра объект HTMLFileFilter.
22.4. Показывать диалоговое окно "Save File" для выбора файла.
22.5. Если пользователь подтвердит выбор файла:
22.5.1. Сохранять выбранный файл в поле currentFile.
22.5.2. Устанавливать имя файла в качестве заголовка окна представления.
22.5.3. Создавать FileWriter на базе currentFile.
22.5.4. Переписывать данные из документа document в объект FileWriter-а аналогично тому, как мы это делали в методе getPlainText().
22.6. Метод не должен кидать исключения.
Проверь работу пункта меню Сохранить как...


Requirements:
1. Метод saveDocumentAs() в контроллере должен переключать представление на html вкладку.
2. Метод saveDocumentAs() в контроллере должен создавать новый объект для выбора файла JFileChooser.
3. Метод saveDocumentAs() в контроллере должен устанавливать объекту класса JFileChooser в качестве фильтра объект HTMLFileFilter.
4. Метод saveDocumentAs() в контроллере должен, используя метод showSaveDialog() у JFileChooser показывать диалоговое окно "Save File" для выбора файла.
5. Метод saveDocumentAs() в контроллере должен сохранять выбранный файл в поле currentFile, если пользователь подтвердит выбор файла.
6. Метод saveDocumentAs() в контроллере должен устанавливать имя файла в качестве заголовка окна представления, если пользователь подтвердит выбор файла.
7. Метод saveDocumentAs() в контроллере должен создавать FileWriter на базе currentFile, если пользователь подтвердит выбор файла.
8. Метод saveDocumentAs() в контроллере должен используя HTMLEditorKit переписывать данные из документа document в объект FileWriter-а, если пользователь подтвердит выбор файла.
9. Метод saveDocumentAs() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
 */