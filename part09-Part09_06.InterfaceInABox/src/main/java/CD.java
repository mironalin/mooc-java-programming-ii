public class CD implements Packable {
    private String bandName;
    private String albumName;
    private int year;
    private double weight;

    public CD(String bandName, String albumName, int year) {
        this.bandName = bandName;
        this.albumName = albumName;
        this.year = year;
        this.weight = 0.1;
    } 

    public double weight() {
        return this.weight;
    }

    public String toString() {
        return this.bandName + ": " + this.albumName + " (" + this.year + ")";
    }
}