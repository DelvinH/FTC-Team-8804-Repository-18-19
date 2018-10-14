package org.firstinspires.ftc.teamcode;

public class PlayingField {
    public static double TILE_LENGTH = 60.7; //in centimeters
    public static double Y_LOWER_BOUNDARY  = -3 * TILE_LENGTH;
    public static double Y_UPPER_BOUNDARY  = 3 * TILE_LENGTH;
    public static double X_LOWER_BOUNDARY  = -3 * TILE_LENGTH;
    public static double X_UPPER_BOUNDARY  = 3 * TILE_LENGTH;

    //Jewel Location
    public static LocationPoint quad1Jewel1 = new LocationPoint(2 * TILE_LENGTH,1 * TILE_LENGTH);
    public static LocationPoint quad1Jewel2 = new LocationPoint(1.5 * TILE_LENGTH,1.5 * TILE_LENGTH);
    public static LocationPoint quad1Jewel3 = new LocationPoint(1 * TILE_LENGTH,2 * TILE_LENGTH);
    public static LocationPoint quad2Jewel1 = new LocationPoint(-1 * TILE_LENGTH,2 * TILE_LENGTH);
    public static LocationPoint quad2Jewel2 = new LocationPoint(-1.5 * TILE_LENGTH,1.5 * TILE_LENGTH);
    public static LocationPoint quad2Jewel3 = new LocationPoint(-2 * TILE_LENGTH,1 * TILE_LENGTH);
    public static LocationPoint quad3Jewel1 = new LocationPoint(-2 * TILE_LENGTH,-1 * TILE_LENGTH);
    public static LocationPoint quad3Jewel2 = new LocationPoint(-1.5 * TILE_LENGTH,-1.5 * TILE_LENGTH);
    public static LocationPoint quad3Jewel3 = new LocationPoint(-1 * TILE_LENGTH,-2 * TILE_LENGTH);
    public static LocationPoint quad4Jewel1 = new LocationPoint(1 * TILE_LENGTH,-2 * TILE_LENGTH);
    public static LocationPoint quad4Jewel2 = new LocationPoint(1.5 * TILE_LENGTH,-1.5 * TILE_LENGTH);
    public static LocationPoint quad4Jewel3 = new LocationPoint(2 * TILE_LENGTH,-1 * TILE_LENGTH);

    public static SquareZone quad1Depot     = new SquareZone(2.0,3.0,2.0,3.0,)
    public static SquareZone quad3Depot     = new SquareZone(-3.0,-2.0,-3.0,-2.0 );
    public static RhombusZone lander        = new RhombusZone(-1,31,1,-1,-31,1);


    //Depot Boundaries



}
