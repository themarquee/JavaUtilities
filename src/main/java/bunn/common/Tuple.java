package bunn.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tuple<F, S> {
	private F first;
	private S second;
}
