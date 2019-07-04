package rsquared.software.recyclerview.grouplist

data class Toggle(val value: Boolean) {
    val isOn
        get() = value
    val isOff
        get() = !value

    fun switch(): Toggle =
        Toggle(!value)
}