package pt.course.bookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*
import javax.persistence.*


@Entity(name = "book")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
class Book : Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null

	@Column(name = "author", nullable = false, length = 180)
	var author: String? = null

	@Column(name = "launch_date", nullable = false)
	@Temporal(TemporalType.DATE)
	var launchDate: Date? = null

	@Column(nullable = false)
	var price: Double? = null

	@Column(nullable = false, length = 250)
	var title: String? = null

	@Transient
	var currency: String? = null

	@Transient
	var environment: String? = null

	constructor() {}
	constructor(
		id: Long?, author: String?, title: String?,
		launchDate: Date?, price: Double?,
		currency: String?,
		environment: String?
	) {
		this.id = id
		this.author = author
		this.launchDate = launchDate
		this.price = price
		this.title = title
		this.currency = currency
		this.environment = environment
	}

	override fun hashCode(): Int {
		val prime = 31
		var result = 1
		result = prime * result + if (author == null) 0 else author.hashCode()
		result = prime * result + if (currency == null) 0 else currency.hashCode()
		result = prime * result + if (environment == null) 0 else environment.hashCode()
		result = prime * result + if (id == null) 0 else id.hashCode()
		result = prime * result + if (launchDate == null) 0 else launchDate.hashCode()
		result = prime * result + if (price == null) 0 else price.hashCode()
		result = prime * result + if (title == null) 0 else title.hashCode()
		return result
	}

	override fun equals(obj: Any?): Boolean {
		if (this === obj) return true
		if (obj == null) return false
		if (javaClass != obj.javaClass) return false
		val other = obj as Book
		if (author == null) {
			if (other.author != null) return false
		} else if (author != other.author) return false
		if (currency == null) {
			if (other.currency != null) return false
		} else if (currency != other.currency) return false
		if (environment == null) {
			if (other.environment != null) return false
		} else if (environment != other.environment) return false
		if (id == null) {
			if (other.id != null) return false
		} else if (id != other.id) return false
		if (launchDate == null) {
			if (other.launchDate != null) return false
		} else if (launchDate != other.launchDate) return false
		if (price == null) {
			if (other.price != null) return false
		} else if (price != other.price) return false
		if (title == null) {
			if (other.title != null) return false
		} else if (title != other.title) return false
		return true
	}

	companion object {
		private const val serialVersionUID = 1L
	}
}
