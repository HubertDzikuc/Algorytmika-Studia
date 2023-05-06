import java.util.ArrayList;

public class Sort {

    public static void selectionSort(int[] array) {
        for(int currentIndex = array.length() - 1; currentIndex > 0; currentIndex--)
        {
            int largestAtIndex = 0;
            for(int i = 1; i <= currentIndex; i++)
            {
                if(array[i] >= array[largestAtIndex])
                {
                    largestAtIndex = i;
                }
            }

            int currentValue = array[currentIndex];
            int largestValue = array[largestAtIndex];
            array[currentIndex] = largestValue;
            array[largestAtIndex] = currentValue;
        }
    }
}
