public class Doctor extends Person {
    private Expertise _EXPERTISE;
    int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    enum Expertise{
        General,Cardiologist,Neurologist,Psychiotrist
    }

    public Expertise get_EXPERTISE() {
        return _EXPERTISE;
    }

    public void set_EXPERTISE(Expertise _EXPERTISE) {
        this._EXPERTISE=_EXPERTISE;

    }

}
