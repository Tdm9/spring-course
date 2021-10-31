package pt.course.bookservice.response;

import java.io.Serializable


class Cambio : Serializable {
	var id: Long? = null
	var from: String? = null
	var to: String? = null
	var conversionFactor: Double? = null
	var convertedValue: Double? = null
	var environment: String? = null

	constructor() {}
	constructor(
		id: Long?, from: String?, to: String?,
		conversionFactor: Double?, convertedValue: Double?,
		environment: String?
	) {
		this.id = id
		this.from = from
		this.to = to
		this.conversionFactor = conversionFactor
		this.convertedValue = convertedValue
		this.environment = environment
	}

	override fun hashCode(): Int {
		val prime = 31
		var result = 1
		result = prime * result + if (conversionFactor == null) 0 else conversionFactor.hashCode()
		result = prime * result + if (convertedValue == null) 0 else convertedValue.hashCode()
		result = prime * result + if (environment == null) 0 else environment.hashCode()
		result = prime * result + if (from == null) 0 else from.hashCode()
		result = prime * result + if (id == null) 0 else id.hashCode()
		result = prime * result + if (to == null) 0 else to.hashCode()
		return result
	}

	override fun equals(obj: Any?): Boolean {
		if (this === obj) return true
		if (obj == null) return false
		if (javaClass != obj.javaClass) return false
		val other = obj as Cambio
		if (conversionFactor == null) {
			if (other.conversionFactor != null) return false
		} else if (conversionFactor != other.conversionFactor) return false
		if (convertedValue == null) {
			if (other.convertedValue != null) return false
		} else if (convertedValue != other.convertedValue) return false
		if (environment == null) {
			if (other.environment != null) return false
		} else if (environment != other.environment) return false
		if (from == null) {
			if (other.from != null) return false
		} else if (from != other.from) return false
		if (id == null) {
			if (other.id != null) return false
		} else if (id != other.id) return false
		if (to == null) {
			if (other.to != null) return false
		} else if (to != other.to) return false
		return true
	}

	companion object {
		private const val serialVersionUID = 1L
	}
}