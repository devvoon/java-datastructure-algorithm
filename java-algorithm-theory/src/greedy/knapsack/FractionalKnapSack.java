package greedy.knapsack;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {

    public static void main(String[] args) {
        System.out.println("[ * FractionalKnapSack * ]");
        int[] wegiht = {10, 40, 20, 30}; 
        int[] value = {60, 40, 100, 120}; 
        int capacity = 50; 
        
        System.out.println("capacity :" + capacity );
        double maxValue = getMaxValue(wegiht, value, capacity); 
        System.out.println("Maximum value  = " +  maxValue); 
    }

    private static double getMaxValue(int[] weight, int[] value, int capacity) {
        
        ItemValue[] itemValue = new ItemValue[weight.length];

        //cost계산
        for (int i = 0; i < itemValue.length; i++) {
             itemValue[i] = new ItemValue(weight[i], value[i], i);
        }
        
        // cost를 기준으로 내림차순 정렬
        Arrays.sort(itemValue, new Comparator<ItemValue>() {
        
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.getCost().compareTo(o1.getCost());
            }
        }); 
        
        System.out.println(toString(itemValue));
        
        double totalValue = 0d;
        
        //cost 가 높은것부터 아이템 한개씩 꺼내서 계산
        for (ItemValue item : itemValue) {
            int currentWeigth = (int)item.weight;
            int currentValue = (int)item.value;
            
            //capacity가 아이템 한개를 다 담을 수 있을 때
            if( capacity - currentWeigth >= 0) {
                
                capacity = capacity - currentWeigth;
                totalValue  = totalValue + currentValue;
                System.out.println("total value : "  + totalValue + ", current weight : " +currentWeigth + ", current value : " + currentValue);
                
            } else {
                //아이템 한 개 를 다 담지 못하는 경우 쪼깸
                // 남은 용량/현재 무게
                double fraction = (double)capacity/(double)currentWeigth;
                
                capacity = (int)(capacity - (currentWeigth*fraction));
                totalValue  = totalValue + (currentValue * fraction);
                
                System.out.println("total value : "  + totalValue + ", current weight : " +currentWeigth + ", current value : " + currentValue + ", fraction :" + fraction);
                break;
            }
        }
        
        return totalValue; 
    }
    
    static class ItemValue{
        private double weight, value, index;
        private double cost;
        
        public ItemValue(int weight, int value, int index) {
            this.weight = weight;
            this.value = value;
            this.index = index;
            //cost 계산
            cost = (value/weight);
        }

        public double getWeight() {
            return weight;
        }

        public double getValue() {
            return value;
        }

        public double getIndex() {
            return index;
        }

        public Double getCost() {
            return cost;
        }
        
    }
    
    
    public static String toString(ItemValue[] input) {
        String str = "[";
      
        for (int i = 0; i < input.length; i++) {
            str += "index : "  + (int)input[i].index
                + ", cost : " + input[i].cost
                + ", value : "  + (int)input[i].value
                + ", weight : "  + (int)input[i].weight;
            
            if (i < input.length-1) {
                str += "/ ";
            }  
        }
        
        return str+"]";
    }
}
