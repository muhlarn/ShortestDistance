package transie;

import java.math.BigDecimal;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transport implements Comparable<Transport> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String origin;
	private String destination;
	private BigDecimal distance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Transport o) {

		int compareId = (int) o.getId();
		/* For Ascending order */
		return (int) this.id - compareId;
	}

	public static Comparator<Transport> TransportOriginComparator = new Comparator<Transport>() {

		public int compare(Transport transport1, Transport transport2) {

			String transportOrigin1 = transport1.getOrigin().toUpperCase();
			String transportOrigin2 = transport2.getOrigin().toUpperCase();

			// ascending order
			return transportOrigin1.compareTo(transportOrigin2);
		}
	};

	@Override
	public String toString() {

		return "\n\nId: " + this.getId() + "\nOrigin: " + this.getOrigin()
				+ "\nDestination: " + this.getDestination() + "\nDistance: "
				+ this.getDistance();
	}

}
