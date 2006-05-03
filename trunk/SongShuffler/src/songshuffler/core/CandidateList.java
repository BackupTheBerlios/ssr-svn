package songshuffler.core;


public interface CandidateList {
    void addItem();
    
    void addList();
    
    void getRandomItem();
    
    void removeItem();
    
    void reset();
    
    void resetAllItemState();
}
