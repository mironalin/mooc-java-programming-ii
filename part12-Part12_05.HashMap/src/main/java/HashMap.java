public class HashMap<KeyType, ValueType> {
    private List<Pair<KeyType, ValueType>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new List[32];
        this.firstFreeIndex = 0;
    }

    public ValueType get(KeyType key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);

        if (this.values[hashValue] == null) {
            return null;
        }

        List<Pair<KeyType, ValueType>> valuesAtIndex = this.values[hashValue];

        for (int i = 0; i < valuesAtIndex.size(); i++)
        if (valuesAtIndex.get(i).getKey().equals(key)) {
            return valuesAtIndex.get(i).getValue();
        }

        return null;
    }

    public void add(KeyType key, ValueType value) {
        List<Pair<KeyType, ValueType>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }

        if(1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }

    public ValueType remove(KeyType key) {
        List<Pair<KeyType, ValueType>> valuesAtIndex = getListBasedOnKey(key);

        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            return null;
        }

        Pair<KeyType, ValueType> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }

    private List<Pair<KeyType, ValueType>> getListBasedOnKey(KeyType key) {
        int hashValue = Math.abs(key.hashCode() & this.values.length);
        if (values[hashValue] == null) {
            values[hashValue] = new List<>();
        }

        return values[hashValue];
    }

    private int getIndexOfKey(List<Pair<KeyType, ValueType>> myList, KeyType key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void copy(List<Pair<KeyType, ValueType>>[] newArray, int fromIdx) {
        for (int i = 0; i < this.values[fromIdx].size(); i++) {
            Pair<KeyType, ValueType> value = this.values[fromIdx].get(i);

            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);

            if (newArray[hashValue] == null) {
                newArray[hashValue] = new List<>();
            }

            newArray[hashValue].add(value);
        }
    }

    private void grow() {
        List<Pair<KeyType, ValueType>>[] newArray = new List[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            copy(newArray, i);
        }

        this.values = newArray;
    }
}