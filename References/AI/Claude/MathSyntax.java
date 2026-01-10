public class MathSyntax {
    public static void main(String[] args) {

        // ========== WHAT IS THE MATH CLASS? ==========

        // Math is a built-in Java class with useful mathematical functions
        // - You DON'T need to import anything (it's in java.lang package)
        // - All methods are STATIC (use Math.methodName())
        // - Contains common math operations like power, square root, rounding, etc.

        System.out.println("=== JAVA MATH LIBRARY ===");
        System.out.println("Built-in mathematical functions for common operations");
        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println();


        // ========== BASIC ARITHMETIC ==========

        System.out.println("=== BASIC ARITHMETIC ===");
        System.out.println();

        // Absolute value (removes negative sign)
        int negativeNumber = -42;
        int absoluteValue = Math.abs(negativeNumber);
        System.out.println("Absolute value of -42: " + absoluteValue);  // 42

        double negativeDecimal = -3.14;
        double absoluteDecimal = Math.abs(negativeDecimal);
        System.out.println("Absolute value of -3.14: " + absoluteDecimal);  // 3.14
        System.out.println();


        // ========== POWER AND ROOTS ==========

        System.out.println("=== POWER AND ROOTS ===");
        System.out.println();

        // Power: Math.pow(base, exponent)
        // Calculates base raised to the power of exponent
        double powerResult = Math.pow(2, 3);  // 2 * 2 * 2 = 8
        System.out.println("2 to the power of 3: " + powerResult);

        double power2 = Math.pow(5, 2);  // 5 * 5 = 25
        System.out.println("5 squared: " + power2);

        double power3 = Math.pow(10, 4);  // 10 * 10 * 10 * 10 = 10000
        System.out.println("10 to the power of 4: " + power3);
        System.out.println();

        // Square root
        double sqrtResult = Math.sqrt(16);  // √16 = 4
        System.out.println("Square root of 16: " + sqrtResult);

        double sqrt2 = Math.sqrt(25);
        System.out.println("Square root of 25: " + sqrt2);

        double sqrt3 = Math.sqrt(2);
        System.out.println("Square root of 2: " + sqrt3);
        System.out.println();

        // Cube root
        double cubeRoot = Math.cbrt(27);  // ∛27 = 3 (because 3*3*3 = 27)
        System.out.println("Cube root of 27: " + cubeRoot);

        double cbrt2 = Math.cbrt(8);
        System.out.println("Cube root of 8: " + cbrt2);
        System.out.println();


        // ========== ROUNDING NUMBERS ==========

        System.out.println("=== ROUNDING NUMBERS ===");
        System.out.println();

        double number = 3.7;

        // Round to nearest integer
        long rounded = Math.round(number);  // Returns long
        System.out.println("Round 3.7: " + rounded);  // 4

        // Round down (floor) - always goes to lower integer
        double floor = Math.floor(3.7);
        System.out.println("Floor of 3.7: " + floor);  // 3.0

        double floor2 = Math.floor(3.2);
        System.out.println("Floor of 3.2: " + floor2);  // 3.0

        double floor3 = Math.floor(-3.7);
        System.out.println("Floor of -3.7: " + floor3);  // -4.0 (goes down)
        System.out.println();

        // Round up (ceiling) - always goes to higher integer
        double ceil = Math.ceil(3.2);
        System.out.println("Ceiling of 3.2: " + ceil);  // 4.0

        double ceil2 = Math.ceil(3.7);
        System.out.println("Ceiling of 3.7: " + ceil2);  // 4.0

        double ceil3 = Math.ceil(-3.7);
        System.out.println("Ceiling of -3.7: " + ceil3);  // -3.0 (goes up)
        System.out.println();

        // Examples to understand rounding
        System.out.println("Understanding rounding:");
        System.out.println("round(2.4) = " + Math.round(2.4));  // 2
        System.out.println("round(2.5) = " + Math.round(2.5));  // 3
        System.out.println("round(2.6) = " + Math.round(2.6));  // 3
        System.out.println();


        // ========== MIN AND MAX ==========

        System.out.println("=== MIN AND MAX ===");
        System.out.println();

        // Find minimum of two numbers
        int min = Math.min(5, 10);
        System.out.println("Min of 5 and 10: " + min);  // 5

        int min2 = Math.min(-3, 2);
        System.out.println("Min of -3 and 2: " + min2);  // -3

        // Find maximum of two numbers
        int max = Math.max(5, 10);
        System.out.println("Max of 5 and 10: " + max);  // 10

        int max2 = Math.max(-3, 2);
        System.out.println("Max of -3 and 2: " + max2);  // 2
        System.out.println();

        // Finding min/max of multiple numbers
        int a = 5, b = 12, c = 3, d = 8;
        int minimum = Math.min(Math.min(a, b), Math.min(c, d));
        System.out.println("Min of 5, 12, 3, 8: " + minimum);

        int maximum = Math.max(Math.max(a, b), Math.max(c, d));
        System.out.println("Max of 5, 12, 3, 8: " + maximum);
        System.out.println();


        // ========== RANDOM NUMBERS ==========

        System.out.println("=== RANDOM NUMBERS ===");
        System.out.println();

        // Math.random() returns a decimal between 0.0 (inclusive) and 1.0 (exclusive)
        double random1 = Math.random();
        System.out.println("Random decimal (0.0 to 1.0): " + random1);

        // Generate random integer from 0 to 9
        int randomInt = (int) (Math.random() * 10);
        System.out.println("Random integer (0-9): " + randomInt);

        // Generate random integer from 1 to 10
        int random1to10 = (int) (Math.random() * 10) + 1;
        System.out.println("Random integer (1-10): " + random1to10);

        // Generate random integer from 1 to 100
        int random1to100 = (int) (Math.random() * 100) + 1;
        System.out.println("Random integer (1-100): " + random1to100);

        // Generate random integer in a range (min to max)
        int min_range = 50;
        int max_range = 100;
        int randomInRange = (int) (Math.random() * (max_range - min_range + 1)) + min_range;
        System.out.println("Random integer (50-100): " + randomInRange);
        System.out.println();


        // ========== TRIGONOMETRIC FUNCTIONS ==========

        System.out.println("=== TRIGONOMETRIC FUNCTIONS ===");
        System.out.println("(All angles are in RADIANS, not degrees)");
        System.out.println();

        // Sine, Cosine, Tangent
        double angle = Math.PI / 4;  // 45 degrees in radians
        System.out.println("Angle: " + angle + " radians (45 degrees)");
        System.out.println("sin(45°): " + Math.sin(angle));
        System.out.println("cos(45°): " + Math.cos(angle));
        System.out.println("tan(45°): " + Math.tan(angle));
        System.out.println();

        // Convert degrees to radians
        double degrees = 90;
        double radians = Math.toRadians(degrees);
        System.out.println("90 degrees = " + radians + " radians");
        System.out.println("sin(90°): " + Math.sin(radians));
        System.out.println();

        // Convert radians to degrees
        double rad = Math.PI / 2;
        double deg = Math.toDegrees(rad);
        System.out.println(rad + " radians = " + deg + " degrees");
        System.out.println();


        // ========== LOGARITHMS AND EXPONENTIAL ==========

        System.out.println("=== LOGARITHMS AND EXPONENTIAL ===");
        System.out.println();

        // Natural logarithm (base e)
        double log = Math.log(10);
        System.out.println("Natural log of 10: " + log);

        // Logarithm base 10
        double log10 = Math.log10(100);
        System.out.println("Log base 10 of 100: " + log10);  // 2 (10^2 = 100)

        // Exponential (e^x)
        double exp = Math.exp(1);  // e^1 = e
        System.out.println("e^1 (Euler's number): " + exp);

        double exp2 = Math.exp(2);  // e^2
        System.out.println("e^2: " + exp2);
        System.out.println();


        // ========== MATHEMATICAL CONSTANTS ==========

        System.out.println("=== MATHEMATICAL CONSTANTS ===");
        System.out.println();

        // PI (π ≈ 3.14159...)
        System.out.println("PI: " + Math.PI);

        // E (Euler's number ≈ 2.71828...)
        System.out.println("E: " + Math.E);
        System.out.println();

        // Using PI to calculate circle area
        double radius = 5;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of circle (radius=5): " + area);

        // Using PI to calculate circle circumference
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circumference of circle (radius=5): " + circumference);
        System.out.println();


        // ========== SIGN FUNCTIONS ==========

        System.out.println("=== SIGN FUNCTIONS ===");
        System.out.println();

        // Get sign of a number (-1, 0, or 1)
        double signum1 = Math.signum(42);
        System.out.println("Sign of 42: " + signum1);  // 1.0 (positive)

        double signum2 = Math.signum(-42);
        System.out.println("Sign of -42: " + signum2);  // -1.0 (negative)

        double signum3 = Math.signum(0);
        System.out.println("Sign of 0: " + signum3);  // 0.0 (zero)
        System.out.println();

        // Copy sign from one number to another
        double copySign = Math.copySign(5.0, -3.0);
        System.out.println("Copy sign of -3 to 5: " + copySign);  // -5.0
        System.out.println();


        // ========== PRACTICAL EXAMPLES ==========

        System.out.println("=== PRACTICAL EXAMPLES ===");
        System.out.println();

        // Example 1: Distance between two points
        System.out.println("Example 1: Distance Between Two Points");
        int x1 = 3, y1 = 4, x2 = 6, y2 = 8;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Point 1: (" + x1 + ", " + y1 + ")");
        System.out.println("Point 2: (" + x2 + ", " + y2 + ")");
        System.out.println("Distance: " + distance);
        System.out.println();

        // Example 2: Calculate percentage
        System.out.println("Example 2: Calculate Percentage");
        double score = 45;
        double total = 60;
        double percentage = (score / total) * 100;
        double roundedPercentage = Math.round(percentage * 100.0) / 100.0;  // Round to 2 decimals
        System.out.println("Score: " + score + "/" + total);
        System.out.println("Percentage: " + roundedPercentage + "%");
        System.out.println();

        // Example 3: Hypotenuse of right triangle
        System.out.println("Example 3: Pythagorean Theorem");
        double side_a = 3;
        double side_b = 4;
        double hypotenuse = Math.sqrt(Math.pow(side_a, 2) + Math.pow(side_b, 2));
        System.out.println("Side A: " + side_a);
        System.out.println("Side B: " + side_b);
        System.out.println("Hypotenuse: " + hypotenuse);
        System.out.println();

        // Example 4: Compound Interest
        System.out.println("Example 4: Compound Interest");
        double principal = 1000;  // Initial amount
        double rate = 0.05;       // 5% interest rate
        int years = 10;           // Time period
        double amount = principal * Math.pow((1 + rate), years);
        System.out.println("Principal: $" + principal);
        System.out.println("Rate: " + (rate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.println("Final Amount: $" + Math.round(amount * 100.0) / 100.0);
        System.out.println();

        // Example 5: Random dice roll (1-6)
        System.out.println("Example 5: Dice Roll");
        int diceRoll = (int) (Math.random() * 6) + 1;
        System.out.println("Dice rolled: " + diceRoll);
        System.out.println();

        // Example 6: Round to specific decimal places
        System.out.println("Example 6: Round to 2 Decimal Places");
        double price = 19.99567;
        double rounded2Decimals = Math.round(price * 100.0) / 100.0;
        System.out.println("Original price: " + price);
        System.out.println("Rounded price: $" + rounded2Decimals);
        System.out.println();


        // ========== COMMON PATTERNS ==========

        System.out.println("=== COMMON PATTERNS ===");
        System.out.println();

        // Pattern 1: Check if number is even
        int num1 = 10;
        boolean isEven = (num1 % 2 == 0);
        System.out.println(num1 + " is even: " + isEven);

        // Pattern 2: Check if number is positive
        int num2 = -5;
        boolean isPositive = (num2 > 0);
        System.out.println(num2 + " is positive: " + isPositive);

        // Pattern 3: Clamp a number between min and max
        int value = 150;
        int minVal = 0;
        int maxVal = 100;
        int clamped = Math.max(minVal, Math.min(maxVal, value));
        System.out.println("Clamp " + value + " between " + minVal + " and " + maxVal + ": " + clamped);
        System.out.println();


        // ========== KEY POINTS TO REMEMBER ==========

        System.out.println("=".repeat(60));
        System.out.println();
        System.out.println("=== KEY POINTS ===");
        System.out.println();
        System.out.println("1. Math class is STATIC - use Math.methodName()");
        System.out.println("2. NO import needed - it's built into Java");
        System.out.println("3. Common operations:");
        System.out.println("   - Math.abs() - Absolute value");
        System.out.println("   - Math.pow() - Power");
        System.out.println("   - Math.sqrt() - Square root");
        System.out.println("   - Math.round() - Round to nearest integer");
        System.out.println("   - Math.floor() - Round down");
        System.out.println("   - Math.ceil() - Round up");
        System.out.println("   - Math.min() - Minimum of two numbers");
        System.out.println("   - Math.max() - Maximum of two numbers");
        System.out.println("   - Math.random() - Random decimal (0.0 to 1.0)");
        System.out.println();
        System.out.println("4. Constants:");
        System.out.println("   - Math.PI - Pi (≈3.14159)");
        System.out.println("   - Math.E - Euler's number (≈2.71828)");
        System.out.println();
        System.out.println("5. Random integer formula:");
        System.out.println("   (int)(Math.random() * (max - min + 1)) + min");
    }
}
