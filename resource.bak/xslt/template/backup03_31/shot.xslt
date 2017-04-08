<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
                <Shot>
                    <Title>
                        <ShotTitle>
                            <xsl:value-of select="MetaData.Shot.Title.ShotTitle"/>
                        </ShotTitle>
                    </Title>
                    <Subject>
                            <SubjectTerm>
                                <xsl:value-of select="MetaData.Shot.Subject.SubjectTerm"/>
                            </SubjectTerm>
                            <Keyword>
                                <xsl:value-of select="MetaData.Shot.Subject.Keyword"/>
                            </Keyword>
                    </Subject>
                    <Description>
                        <DescriptionofContent>
                            <xsl:value-of select="MetaData.Shot.Description.DescriptionofContent"/>
                        </DescriptionofContent>
                        <ShootingPlace>
                            <xsl:value-of select="MetaData.Shot.Description.ShootingPlace"/>
                        </ShootingPlace>
                            <CameraMotion>
                                <xsl:value-of select="MetaData.Shot.Description.CameraMotion"/>
                            </CameraMotion>
                            <CameraMotion>
                                <xsl:value-of select="MetaData.Shot.Description.CameraMotion"/>
                            </CameraMotion>
                            <CameraMotion>
                                <xsl:value-of select="MetaData.Shot.Description.CameraMotion"/>
                            </CameraMotion>
                        <NaturalSound>
                            <xsl:value-of select="MetaData.Shot.Description.NaturalSound"/>
                        </NaturalSound>
                    </Description>
                    <Date>
                        <xsl:value-of select="MetaData.Shot.Date"/>
                    </Date>
                    <Format>
                        <Duration>
                            <xsl:value-of select="MetaData.Shot.Format.Duration"/>
                        </Duration>
                        <StartingPoint>
                            <xsl:value-of select="MetaData.Shot.Format.StartingPoint"/>
                        </StartingPoint>
                    </Format>
                    <Relation>
                        <IsPartof>
                            <xsl:value-of select="MetaData.Shot.Relation.IsPartof"/>
                        </IsPartof>
                        <References>
                            <xsl:value-of select="MetaData.Shot.Relation.References"/>
                        </References>
                    </Relation>
                </Shot>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>