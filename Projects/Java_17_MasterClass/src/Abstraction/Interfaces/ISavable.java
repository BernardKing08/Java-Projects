package Abstraction.Interfaces;

import java.util.List;

public interface ISavable {
    public List<String> write();

    public void read(List<String> value);
}
