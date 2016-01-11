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


}
