public class List<Generic> {
    private Generic[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (Generic[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Generic value) {
        if (this.firstFreeIndex == this.values.length) {
            growList();
        }

        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    public void growList() {
        int newSizeOfList = this.values.length + this.values.length / 2;
        Generic[] newList = (Generic[]) new Object[newSizeOfList];

        for (int i = 0; i < this.firstFreeIndex; i++) {
            newList[i] = this.values[i];
        }

        this.values = newList;
    }

    public boolean contains(Generic value) {
        return indexOf(value) >= 0;
    }

    public Generic get(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + "outside of [0, " + this.firstFreeIndex + "]");
        }

        return this.values[index];
    }

    public int indexOf(Generic value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void moveLeft(int startIndex) {
        for (int i = startIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public void remove(Generic value) {
        int indexOf = indexOf(value);
        if (indexOf < 0) {
            System.out.println("Value not found.");
        } else {
            moveLeft(indexOf);
            this.firstFreeIndex--;
        }
    }

    public void remove(int indexToRemove) {
        if (indexToRemove < 0 || indexToRemove >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException(
                    "Index " + indexToRemove + "outside of [0, " + this.firstFreeIndex + "]");
        }

        moveLeft(indexToRemove);
        this.firstFreeIndex--;
    }

    public void clear() {
        this.values = (Generic[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public int size() {
        return this.firstFreeIndex;
    }
}