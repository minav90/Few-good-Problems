class Building < ActiveRecord::Base
	self.primary_key = "building_id"
	has_many :room
end
