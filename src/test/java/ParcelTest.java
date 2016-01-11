import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest {

  @Test
  public void newParcel_setsLength_3() {
    Parcel testParcel = new Parcel(3, 5, 6, 10);
    assertEquals(3, testParcel.getLength());
  }

  @Test
  public void newParcel_setsWidth_5() {
    Parcel testParcel = new Parcel(3, 5, 6, 10);
    assertEquals(5, testParcel.getWidth());
  }

  @Test
  public void newParcel_setsHeight_6() {
    Parcel testParcel = new Parcel(3, 5, 6, 10);
    assertEquals(6, testParcel.getHeight());
  }

  @Test
  public void newParcel_setsWeight_10() {
    Parcel testParcel = new Parcel(3, 5, 6, 10);
    assertEquals(10, testParcel.getWeight());
  }

  @Test
  public void volume_returnsCorrectVolume_6() {
    Parcel testParcel = new Parcel(1, 2, 3, 99);
    assertEquals(6, testParcel.volume());
  }

  @Test
  public void cost_to_ship_returnsCorrectCostInCents_1200() {
    Parcel testParcel = new Parcel(1, 2, 3, 20);
    Integer expectedResult = 1200;
    Integer actualResult = testParcel.cost_to_ship(100);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void isEligibleForLowWeightDiscount_returnsCorrectResponse_true() {
    Parcel testParcel = new Parcel(1, 2, 3, 1);
    assertEquals(true, testParcel.isEligibleForLowWeightDiscount());
  }

  @Test
  public void cost_to_giftwrap_returnsCorrectCostInCents_300() {
    Parcel testParcel = new Parcel(10, 10, 10, 35);
    assertEquals(300, testParcel.cost_to_giftwrap());
  }

  @Test
  public void isEligibleForLowWeightDiscount_returnsCorrectResponse_false() {
    Parcel testParcel = new Parcel (1, 2, 3, 10);
    assertEquals(false, testParcel.isEligibleForLowWeightDiscount());
  }


}
