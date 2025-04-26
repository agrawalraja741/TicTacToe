package Validators;

public class Validators {

    public static void validateGridSize(int size)
    {
        if(size <= 2)
            throw new RuntimeException("Grid size must be greater than 2");
    }

    public static void validatePlayerNo(int size, int playerNo)
    {
        if(playerNo <= 1)
            throw new RuntimeException("Player number must be greater than 1");

        if(playerNo >= size)
            throw new RuntimeException("Player number must be less than size of grid");
    }
}
