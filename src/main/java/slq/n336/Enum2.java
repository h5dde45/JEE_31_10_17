package slq.n336;

enum Doc1{
    FIRST,
    SECOND(34),
    THIRD;

    private int weight;

//    Doc1() {
//        this.weight = 21;
//    }

    Doc1(int weight) {
        this.weight = weight;
    }


    Doc1() {

    }

    public int getWeight() {
        return weight;
    }
}

public class Enum2 {
    public static void main(String[] args) {
        Doc1 doc1 = Doc1.THIRD;
        System.out.println(doc1.getWeight());

        for (Doc1 doc11:Doc1.values()){
            System.out.println(doc11+" = "+doc11.getWeight());
        }

    }
}
