package DZ03.Market;

/***
 * Функциональный интерфейс для конвертации значения в ms
 * используется в конструкторе Food
 */
public interface ToMs<T> {
    long getMS(T n);
}
