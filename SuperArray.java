// A Lonely Little Triangle - Matthew So
// APCS1 pd10
// HW45 -- Come Together
// 2015-12-9

public class SuperArray implements ListInt {

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data = new Comparable[10];
	_lastPos = -1;
	_size = 0;
    }
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	String storage = "["; // Keeps track of non-zeros.
	String stack = "";    // Keeps track of zeros.
	for (int i = 0; i < _size; i++) {
	    storage += _data[i] + ",";
	}
	if (storage.equals("[")) {return "[]";}
	return storage.substring(0,storage.length()-1) + "]";
    }

    //swap - switches two indices of the array
    //precond: int i1, i2 - two indices to be swapped
    public void swap(int i1, int i2) {
	_data[i1] = set(i2, _data[i1]);
    }

    //add - adds an item to the end of the array and gives the index meaning
    //precond: int value - value to be added at the end
    public void add(Comparable value) {
	if (_size+1 >= _data.length) {expand();} // Increases size if no space
	_data[_lastPos+1] = value;
	_lastPos += 1; // Afterwards, in case there is an error.
	_size += 1;
    }
    //add - adds an item to an index of the array and shifts array to the right
    //precond: int value - value to be added
    //         int index - index to add to
    public void add(int index, Comparable value) {
	if (_size+1 >= _data.length) {expand();}
	add(value);
	for (int i = _lastPos; i > index; i--) { // "bubble swap" backwards.
	    swap(i,i-1);
	}
    }

    //remove - removes an item at a specified index and shifts everything left
    //precond: int index - index to be removed;
    public void remove(int index) {
	for (int i = index; i < _lastPos; i++) {
	    swap(i,i+1);
	}
	_lastPos -= 1;
	_size -= 1;
    }
    //remove - removes last meaningful element
    public void remove() {
	remove(_lastPos);
    }
    
    //double capacity of this SuperArray
    private void expand() {
	int len = _data.length * 2;
	Comparable[] copy = new Comparable[len];
	for (int i = 0; i < len / 2; i++) {
	    copy[i] = _data[i];
	}
	_data = copy;
    }
		
    //accessor -- return value at specified index
    public Comparable get( int index ) {
	return _data[index];
    }
    public int size() {
	return _size;
    }

    public int linSearch(Comparable input){
	for (int i = 0; i < _size; i++){
	    if  (_data[i].compareTo(input) == 0){
		return i;}}
	return -1;}
    //returns true if sorted, otherwise false
    public boolean isSorted(){
	boolean ret = true;
	Comparable prev = _data[0];
	for (int i =0 ; i < _size;i++){
	    if (!((_data[i].compareTo(prev) >= 0))){
		ret = false;}
	    prev = _data[i];}
	return ret;}
	    
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable value ) {
	Comparable storage = _data[index];
	_data[index] = value;
	return storage;
    }


    //main method for testing
    public static void main( String[] args ) {
	// // ------PHASE I------
	// SuperArray oof = new SuperArray();
	// System.out.println("Phase I Testing:\n" + oof);
	// oof.expand();
	// System.out.println(oof);
	// for (int i = 0; i < 20; i++) {
	//     oof.set(i, i*i);
	// }
	// System.out.println(oof);
	// System.out.println(oof.get(3) + oof.get(4)); // 25
	// oof.expand();
	// // ------PHASE II------
	// System.out.println(oof + "\n\n" +
	// 		   "Phase II Testing:");
	// SuperArray rab = new SuperArray();
	// for (int i = 0; i < 10; i++) {
	//     rab.add(i);
	// }
	// System.out.println(rab);
	// rab.add(5,101);
	// System.out.println(rab);
	// for (int i = 11; i < 16; i++) {
	//     rab.add(i, i*10);
	// }
	// System.out.println(rab);
	// rab.remove(0);
	// System.out.println(rab);
	// rab.remove(4);
	// System.out.println(rab);
	// rab.remove();
	// rab.remove();
	// System.out.println(rab);
	// // ------PHASE III------
	// System.out.println(oof + "\n\n" +
	// 		   "Phase III Testing:");
	// ListInt foo = new SuperArray();
	// for (int i = 0; i < 10; i++) {
	//     foo.add(i*i*i);
	// }
	// foo.add(0,-10);
	// System.out.println(foo);
	// foo.add(100);
	// System.out.println(foo);
	// foo.remove(5);
	// System.out.println(foo);
	// System.out.println(foo.size());
	// System.out.println(foo.get(5));
	// foo.set(5,1000);
	// System.out.println(foo.get(5));

	//Come Together
	SuperArray Compare = new SuperArray();
	Rational rat = new Rational(50,4);
	Binary bin = new Binary(10);
	Hexadecimal hex = new Hexadecimal(15);
	Compare.add(rat);
	Compare.add(bin);
	Compare.add(hex);
	System.out.println(Compare);
	System.out.println(Compare.linSearch(bin));
	System.out.println(Compare.isSorted());
	
	
    }//end main
		
}//end class
