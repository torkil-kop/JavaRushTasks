package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit");
  @Override
  public void execute() throws InterruptOperationException {
      ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

      String s = ConsoleHelper.readString();
      if (s.equalsIgnoreCase("y")) {
          ConsoleHelper.writeMessage(res.getString("thank.message"));
      }

  }
 }
/*
1. Реализуй следующую логику в команде ExitCommand:
1.1. Спросить, действительно ли пользователь хочет выйти - варианты <y,n>.
1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.
1.3. Если пользователь не подтвердит свои намерения, то не прощаться с ним, а просто выйти.

Это всё хорошо, но бывают случаи, когда срочно нужно прервать операцию, например, если пользователь ошибся с выбором операции.
Для этого у нас есть InterruptOperationException.
2.Реализуй следующую логику:
2.1. Если пользователь в любом месте ввел текст 'EXIT' любым регистром, то выбросить InterruptOperationException.
2.2. Найди единственное место, куда нужно вставить эту логику. Реализуй функционал в этом единственном методе.

3. Заверни тело метода main в try-catch и обработай исключение InterruptOperationException.
Попрощайся с пользователем в блоке catch используя ConsoleHelper.
 */