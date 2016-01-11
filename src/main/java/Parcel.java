import java.lang.Math;

public class Parcel {
  private final int mLengthInCM;
  private final int mWidthInCM;
  private final int mHeightInCM;
  private final int mWeightInKilos;

  public Parcel(int length, int width, int height, int weight) {
    mLengthInCM = length;
    mWidthInCM = width;
    mHeightInCM = height;
    mWeightInKilos = weight;
  }

  public int getLength() {
    return mLengthInCM;
  }

  public int getWidth() {
    return mWidthInCM;
  }

  public int getHeight() {
    return mHeightInCM;
  }

  public int getWeight() {
    return mWeightInKilos;
  }

  public int volume() {
    return mLengthInCM * mWidthInCM * mHeightInCM;
  }

  public int surfaceAreaInCM2() {
    return 2 * ((mWidthInCM * mLengthInCM) + (mHeightInCM * mLengthInCM) + (mHeightInCM * mWidthInCM));
  }

  public int cost_to_giftwrap() {
    return Integer.valueOf((int)Math.round(this.surfaceAreaInCM2() / 2));
  }

  public int cost_to_ship(int distanceToShipInKM) {
    double cost = (distanceToShipInKM / 10) * this.volume() * mWeightInKilos;
    Integer costInCents = Integer.valueOf((int)Math.round(cost));
    return costInCents;
  }

  public boolean isEligibleForLowWeightDiscount() {
    //low weight discount
    if (mWeightInKilos <= 2) {
      return true;
    } else {
      return false;
    }
  }

}
