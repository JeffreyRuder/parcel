public class ShippingRequest {
  private final int mDistance;
  private final boolean mGiftWrapRequest;

  public ShippingRequest(int distance, boolean giftWrap) {
    mDistance = distance;
    mGiftWrapRequest = giftWrap;
  }

  public int getDistance() {
    return mDistance;
  }

  public boolean giftWrapRequested() {
    return mGiftWrapRequest;
  }
}
