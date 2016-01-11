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

  public double cost_to_ship(double distanceInKM) {
    double cost = (distanceInKM / 100) * this.volume() * (mWeightInKilos / 10) * 1.15;
    return cost;
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
