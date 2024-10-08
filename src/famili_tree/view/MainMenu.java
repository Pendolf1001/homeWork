package view;

import view.comand.*;
import java.util.ArrayList;
import java.util.List;
public class MainMenu {
    private List<Command> commandList;
    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GetTreeInfo(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new AddSuprugById(consoleUI));
        commandList.add(new AddSuprugByNum(consoleUI));
        commandList.add(new AddChildByNum(consoleUI));
        commandList.add(new AddChildById(consoleUI));
        commandList.add(new AddParentByNum(consoleUI));
        commandList.add(new AddParentById(consoleUI));
        commandList.add(new GetParentByNum(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(Integer.toString(i+1));
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }
    public int getSize(){
        return commandList.size();
    }
}
